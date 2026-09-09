package me.rerere.rikkahub.ui.components.richtext

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString

private const val LEFT_TO_RIGHT_ISOLATE = '\u2066'
private const val POP_DIRECTIONAL_ISOLATE = '\u2069'

// 匹配完整的拉丁字母/数字片段，例如 "299 USD"、"12 GB"、"Snapdragon 8s Gen 4"。
// 末尾标点不纳入片段，交还给外层的 RTL 段落处理，保证其位置正确。
private val LTR_RUN_IN_RTL_PARAGRAPH = Regex(
    "[A-Za-z0-9]+(?:[._/+:-][A-Za-z0-9]+)*(?:[ \\t]+[A-Za-z0-9]+(?:[._/+:-][A-Za-z0-9]+)*)*"
)

/** 按正文中的字母判断主体方向，避免开头的英文型号决定整段阿拉伯文的方向。 */
internal fun hasPredominantlyRtlLetters(text: String): Boolean {
    var rtlLetters = 0
    var ltrLetters = 0
    var offset = 0
    while (offset < text.length) {
        val codePoint = Character.codePointAt(text, offset)
        if (Character.isLetter(codePoint)) {
            when (Character.getDirectionality(codePoint)) {
                Character.DIRECTIONALITY_RIGHT_TO_LEFT,
                Character.DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC -> rtlLetters++
                Character.DIRECTIONALITY_LEFT_TO_RIGHT -> ltrLetters++
            }
        }
        offset += Character.charCount(codePoint)
    }
    return rtlLetters > ltrLetters
}

/**
 * 在 RTL 段落中隔离 LTR 片段，防止 "299 USD" 被重排成视觉上的 "USD 299"。
 *
 * 仅处理用于显示的 [AnnotatedString]，不改变原消息。分段追加会保留原有的 Markdown
 * 样式、链接和行内内容标记。
 */
internal fun AnnotatedString.isolateLtrRunsForRtlParagraph(): AnnotatedString {
    val matches = LTR_RUN_IN_RTL_PARAGRAPH.findAll(text).toList()
    if (matches.isEmpty()) return this
    val sourceLength = length

    return buildAnnotatedString {
        var sourceOffset = 0
        matches.forEach { match ->
            append(this@isolateLtrRunsForRtlParagraph.subSequence(sourceOffset, match.range.first))
            append(LEFT_TO_RIGHT_ISOLATE)
            append(this@isolateLtrRunsForRtlParagraph.subSequence(match.range.first, match.range.last + 1))
            append(POP_DIRECTIONAL_ISOLATE)
            sourceOffset = match.range.last + 1
        }
        append(this@isolateLtrRunsForRtlParagraph.subSequence(sourceOffset, sourceLength))
    }
}
