package ciphers;

import org.junit.Test;
import utils.CipherDictionary;
import utils.CipherUtils;

public class CaesarCipherTest {

    @Test
    public void testEncryption() {

        CaesarCipher caesarCipher = new CaesarCipher(1);
        String cipherText = caesarCipher.encrypt("hello");
        assert cipherText.equals("ifmmp");
    }

    @Test
    public void testDecryption() {

        CaesarCipher caesarCipher = new CaesarCipher(1);
        String plainText = caesarCipher.decrypt("ifmmp");
        assert plainText.equals("hello");
    }

    @Test
    public void testEncryptThenDecrypt() {

        CaesarCipher caesarCipher = new CaesarCipher(3);
        String plainText = "s s";
        String cipherText = caesarCipher.encrypt(plainText);
        String decryptedText = caesarCipher.decrypt(cipherText);
        assert plainText.equals(decryptedText);
    }

    @Test
    public void testFullDecryption() {
        String cipherText = "MJFADTQIKFXMNTSJIKZWSNYZWJHWNRXTSIFRFXPMFSLNSLXFSIFSJSTWRTZXKTZWUTXYGJIXYJFIFQTSLYMJMJFITKBMNHMBJWJHFWAJIWZSSNSLKNLZWJXFUUFWJSYQDFYFQFSYFXWFHJWJXYFYQFXYXFNIMJXJYYNSLITBSMNXGFLFSIYMJUFWHJQTKANFSIXYMJDWJRFNSJINSLWJFYVZNJYSJXXYNQQYMJHFWJYFPJWXMTZQIMFAJHTRJYTXMZYYMJBNSITBXFXFUWJHFZYNTSUZYYNSLYMJRXJQAJXNSYTYFQIFWPSJXXGDGFWWNSLYMJXMZYYJWXFXGJKTWJQJXYYMJBTRFSXMTZQITUJSYMJITTWTKYMJNWHMFRGJWKTWFSDHFXZFQWJFXTSGJYBJJSXNCFSIXJAJSTHQTHPXMJHFRJGZYINISTYFUUWTFHMYMJBNSLYMJDBJWJNSYMJDMJFWIMJWHQTXJYMJBNSITBXKFXYJSYMJRQTHPYMJITTWFSILTFBFDYMJSHQFWJFLFNSXYTQJFHMNSPTKQNLMYKWTRYMJBNSITBFSIYMJDXMFWJIFSTYMJWRJFQYNQQGDFSIGDYMJDBJWJJSAJQTUJINSYMJXMFIJXTKSNLMYBMNHMYMJDMFISTHFSIQJYTINXUJWXJQANNNYMJSNLMYBFXXYWFSLJQDXTQJRSFSIXYNQQNSYMJXRFQQMTZWXXMJBMNXUJWJIYTMNRYMJBMTQJXYTWDTKMTBMJMFIBFQPJINSMNXXQJJUBNYMMJWNSMNXFWRXFHWTXXYMJKWTTRXYWJFRFYYMJNRRNSJSYWNXPTKGTYMY";
        //CipherDictionary cd = new CipherDictionary();
        for (int i = 0; i < 27; i++) {
            CaesarCipher caesarCipher = new CaesarCipher(i);
            System.out.println(caesarCipher.decrypt(cipherText));
        }
    }
}
