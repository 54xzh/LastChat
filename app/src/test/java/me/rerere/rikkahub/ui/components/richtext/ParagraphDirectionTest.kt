package me.rerere.rikkahub.ui.components.richtext

import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ParagraphDirectionTest {
    @Test
    fun `Arabic paragraph keeps its direction after an English model name`() {
        assertTrue(hasPredominantlyRtlLetters(
            "Snapdragon 8s Gen 4 تعتبر شريحة متطوراً يجمع بين الأداء العالي والتكلفة المتوازنة."
        ))
        assertTrue(hasPredominantlyRtlLetters("123 تعتبر شريحة متطورة"))
    }

    @Test
    fun `English and Chinese paragraphs retain automatic direction`() {
        assertFalse(hasPredominantlyRtlLetters("The Arabic word مرحبا means hello."))
        assertFalse(hasPredominantlyRtlLetters("这是一段包含阿拉伯文 مرحبا 的中文说明。"))
        assertFalse(hasPredominantlyRtlLetters("Snapdragon 8s Gen 4"))
    }

    @Test
    fun `numbers punctuation and combining marks do not outweigh letters`() {
        assertTrue(hasPredominantlyRtlLetters("1234567890 (مرحبا) ١٢٣٤٥٦٧٨٩٠!"))
        assertFalse(hasPredominantlyRtlLetters("abc بََََََََََ"))
        assertFalse(hasPredominantlyRtlLetters("123 ١٢٣ !؟"))
        assertFalse(hasPredominantlyRtlLetters(""))
        assertFalse(hasPredominantlyRtlLetters("a ب"))
    }

    @Test
    fun `supplementary letters are counted as complete code points`() {
        // 两个扩展汉字与一个阿拉伯字母：不能因汉字使用代理对而漏计。
        assertFalse(hasPredominantlyRtlLetters("𠀀𠀁 ب"))
        assertTrue(hasPredominantlyRtlLetters("𠀀 مرحبا"))
    }

    @Test
    fun `LTR runs in an Arabic paragraph are isolated without their punctuation`() {
        val source = "السعر هو 299 USD، والذاكرة 12 GB، وسعة التخزين 256 GB."

        assertEquals(
            "السعر هو \u2066299 USD\u2069، والذاكرة \u206612 GB\u2069، وسعة التخزين \u2066256 GB\u2069.",
            buildAnnotatedString { append(source) }.isolateLtrRunsForRtlParagraph().text,
        )
    }

    @Test
    fun `isolating LTR runs preserves Markdown span styles`() {
        val source = buildAnnotatedString {
            append("يوفر ")
            withStyle(SpanStyle(fontWeight = FontWeight.SemiBold)) {
                append("Snapdragon 8s Gen 4")
            }
            append(" أداءً قوياً")
        }

        val isolated = source.isolateLtrRunsForRtlParagraph()

        assertEquals("يوفر \u2066Snapdragon 8s Gen 4\u2069 أداءً قوياً", isolated.text)
        assertEquals(1, isolated.spanStyles.size)
        assertEquals(6, isolated.spanStyles.single().start)
        assertEquals(25, isolated.spanStyles.single().end)
        assertEquals(FontWeight.SemiBold, isolated.spanStyles.single().item.fontWeight)
    }
}
