import com.cs.wechat.WxMpDemoApplication;
import com.cs.wechat.security.JwtTokenUtil;
import com.cs.wechat.utils.ExportExcel;
import com.github.binarywang.java.emoji.EmojiConverter;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Created by cs on 2017/8/28.
 */

public class TestEmoji {
    private EmojiConverter emojiConverter = EmojiConverter.getInstance();

    private ExportExcel exportExcel = new ExportExcel();

    @Test
    public void testToAlias() {
        String str = "  An 😃😀awesome 😃😃string with a few 😃😉emojis!";
        String alias = this.emojiConverter.toAlias(str);
        System.out.println(str);
        System.out.println("EmojiConverterTest.testToAlias()=====>");
        System.out.println(alias);
        Assert.assertEquals(
                ":no_good: :ok_woman: :couple_with_heart:An :smiley::grinning:awesome :smiley::smiley:string with a few :smiley::wink:emojis!",
                alias);
    }

    @Test
    public void testToHtml() {
        String str = "  An 😀😃awesome 😃😃string with a few 😉😃emojis!";
        String result = this.emojiConverter.toHtml(str);
        System.out.println(str);
        System.out.println("EmojiConverterTest.testToHtml()=====>");
        System.out.println(result);
        Assert.assertEquals(
                "&#128581; &#128582; &#128145;An &#128512;&#128515;awesome &#128515;&#128515;string with a few &#128521;&#128515;emojis!",
                result);
    }

    @Test
    public void testToUnicode() {
        String str = "   :smiley: :grinning: :wink:";
        String result = this.emojiConverter.toUnicode(str);
        System.err.println(str);
        System.err.println("EmojiConverterTest.testToUnicode()=====>");
        System.err.println(result);
        Assert.assertEquals("🙅 🙆 💑 😃 😀 😉", result);
    }

    @Test
    public void testOut(){
        exportExcel.Export();
    }

}
