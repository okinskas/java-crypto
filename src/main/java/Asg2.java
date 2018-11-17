import jdk.jfr.Frequency;

import java.util.HashMap;
import java.util.stream.IntStream;

public class Asg2 {

    public static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static double[] freqArray = new double[ALPHABET.length()];

    static {
        freqArray[0] = 8.167;
        freqArray[1] = 1.492;
        freqArray[2] = 2.782;
        freqArray[3] = 4.253;
        freqArray[4] = 12.702;
        freqArray[5] = 2.228;
        freqArray[6] = 2.015;
        freqArray[7] = 6.094;
        freqArray[8] = 6.996;
        freqArray[9] = 0.153;
        freqArray[10] = 0.772;
        freqArray[11] = 4.025;
        freqArray[12] = 2.406;
        freqArray[13] = 6.749;
        freqArray[14] = 7.507;
        freqArray[15] = 1.929;
        freqArray[16] = 0.095;
        freqArray[17] = 5.987;
        freqArray[18] = 6.327;
        freqArray[19] = 9.056;
        freqArray[20] = 2.758;
        freqArray[21] = 0.978;
        freqArray[22] = 2.460;
        freqArray[23] = 0.150;
        freqArray[24] = 1.974;
        freqArray[25] = 0.074;
    }

    private static String ex3 = "NQLKMROXLSNRLASABBIYDAQGFEDTBLGIZNBKYWERMQAXSONBIYCWWQXICFCOBYDBIQXWTNBHFPTGMQWIHHWVYRLMMBIYSADHHIGEZWIPOMMDVSFTPDPMYGEKUXEHMBWEWLIQYXSIKDFWJSBHGATTPROXLNGGIKXAQGIRESMHGCHAGWIXSABDNEWLEKSCZUKDHLLVMWBICETLAMZNWIFSGIVJEMYDVHMWLNLSOVTTGDNPPAAWCJJOCFUREHIYYASABGICZUKDFPTTLRAQLOVRCQLDQIZICEVWMSCTWIZIWLWZZVZMBKUXTFBKYVPSVRVSOYBRMEJDWWBMDAVGCXHITOVILGWRXXSIVJZSCYWXUJEEZBIYLRMGYEODWWBEEAVGCJHITOVILBIGNLTNOIIVJOCLWEYTEDLQFPPDHKTTQDGRZTORCRRTWIYIWRMVJSYSQEFIQOZPSHPELVUROPIVMMZNALZXSEZHMRZBWGSXZBMUYWAOVVCFWEBRUROINLQICEGROQJDMDLMHOCOXREEQWBICSPHNVTELWIECGCHUROTMOFLTMBKUXSEPDXQTXMGCRSIAGOPWBZDCREWWPUXEEZVNLPOTRACLNLPIVLLAZBMNHQQNLPPZLGMEIDHXEJSWIGEYKQQXLLDJHYRBUQWYHTSBLHGEBCWIATNOWIEYGMOWPLRMVLIEIKHHGPTWKYVLBARFYEEEDHXZFBUUMYIVJUROTWKYVMEQQAEGEAVYPZFMPIXTOVVLEEHMUNLLNZHUWZNAVBINOCOXRZTOHNSYWMOFRPVMUGMYDPHLIDUUHXLPRMLUQXYTRPILSQQNLPOTGNMXEAQ";
    private static String ex4 = "FVLYICQURFHQOCPCNRFBLPRCQGIJGCYCBMKHYAMFWKALLNPBPVIEEQXEOBKOWVNPBZYEWLOBFYHYSFYVHYGCPMCGGIFSFYVHYFFBLOCCXNOQLLNOKNBWDVLDNRVQEYRNBMODUGPUBZJFARGJVLYHLABOEUXCCGREYWBKBHDNDQYBFNBUUVLDVOACXNRUCOBKAEFHQGYFFYSFXCBGFBSYHLDYBQYFLIZYFXCVLZFEQGKADRQPVBRYHZKFRBXGVRENRRGOBKVPIIYFCLHCHLAUIZMOHSAEPVOSMOYLHGIXSAEFNECCUNBNFFARSMOUDGCKXSAEZBEEAEUCGWIYDUCVWYHJAHYGYAIZGUEYXZGIESAETCDUREYSEFBUNFYDUSAQQNRRALQCVDPBOUYAMKVBVYCVLPNONBLZXBFBQYHJABKICHCCFCABOEGQBKQCSCNRLQFIOCBHRVQFHDRLQCYAZRNRRPAYDRPJCXRBKYQNRFPOQCQYBECABSFQZLECSIIEFFBUBGREYSEALHNVRFIXBDAIWVAFFSNPVWYZPXXOFFFJZHREYBNQQBOJMJUXGMPOMUBFMKQTXHDNEBVIVRPYXSMOWOQGKNOEALOBFCQBKGFBZOYRFNEADXCBGMEYBGMBROEAFMONLVJBRQPOBRMCVVNLACCUKBHDJFFWRUCJCQUREUFRFLHOFRISOZNIIIRBEUNFFBVORLYYDGCOULYCQIKIMFXRVKEYBRJBUCRBEYBZMJYXGYOCVLGJJBVQLHOQUXCCGYKXGVREBOYBQBOXGPMSGYIFDHPKYNBLQBKGPBFONQBQRNREUNTGSYXUCOMDECKADURL";

    public static String[] decryptVigenere(String s, int keyLen) {

        String[] cols = new String[keyLen];
        for (int i = 0; i < keyLen; i++) {
            cols[i] = "";
            for (int j = i; j < s.length(); j += keyLen) {
                cols[i] += s.charAt(j);
            }
        }
        for (String sub : cols) {
            System.out.println(sub);
        }
        return cols;
    }

    public static String[] getAllCaesars(String s) {
        String[] all = new String[ALPHABET.length()];
        for (int i = 0; i < ALPHABET.length(); i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                int index = ALPHABET.indexOf(s.charAt(j));
                int caesarIndex = (index + i) % ALPHABET.length();
                builder.append(ALPHABET.charAt(caesarIndex));
            }
            all[i] = builder.toString();
        }
        return all;
    }

    public static double[] getFreqArray(String s) {
        double[] frequencies = new double[ALPHABET.length()];
        HashMap<Character, Integer> charCounts = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            int currentCount = charCounts.getOrDefault(s.charAt(i), 0);
            charCounts.put(s.charAt(i), currentCount + 1);
        }

        for (int j = 0; j < ALPHABET.length(); j++) {
            int currentCount = charCounts.getOrDefault(ALPHABET.charAt(j), 0);
            double currentFrequency = ((double) currentCount / s.length()) * 100;
            frequencies[j] = currentFrequency;
        }
        return frequencies;
    }

    public static double compareFrequencies(double[] charFrequencies) {
        double totalDiff = 0;
        for (int i = 0; i < charFrequencies.length; i++) {
            totalDiff += (Math.abs(charFrequencies[i] - freqArray[i]));
        }
        return totalDiff;
    }

    public static String getCaesar(String s, int k) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int index = ALPHABET.indexOf(s.charAt(i));
            int caesarIndex = (index + k) % ALPHABET.length();
            builder.append(ALPHABET.charAt(caesarIndex));
        }
        return builder.toString();
    }

    public static void solveVigenere(String s, int keyLen) {
        String[] sections = decryptVigenere(s, keyLen);
        int[] shifts = new int[6];
        for (int i = 0; i < sections.length; i++) {
            double lowestDiff = Double.MAX_VALUE;
            int shift = 0;
            String[] caesars = getAllCaesars(sections[i]);
            for (int j = 0; j < caesars.length; j++) {
                double[] freqs = getFreqArray(caesars[j]);
                double diff = compareFrequencies(freqs);
                if (diff < lowestDiff) {
                    lowestDiff = diff;
                    shift = j;
                }
                System.out.println(ALPHABET.charAt(j) + " : " + diff);
            }
            System.out.println(lowestDiff);
            shifts[i] = shift;
        }

        String[] results = new String[keyLen];
        for (int j = 0; j < sections.length; j++) {
            String shifted = getCaesar(sections[j], shifts[j]);
            results[j] = shifted;
            System.out.println(shifted);
        }

        prettyPrintVigenere(results);
    }

    public static void solveEx3() {
        solveVigenere(ex3, 6);
    }

    public static void solveEx4() {
        for (int n = 4; n <= 6; n++) {
            solveVigenere(ex4, n);
        }
    }

    public static void prettyPrintVigenere(String[] sections) {
        StringBuilder prettyString = new StringBuilder();
        for (int i = 0; i < sections[0].length(); i++) {
            for (String section : sections) {
                prettyString.append(section.charAt(i));
            }
        }
        System.out.println(prettyString.toString());
    }

    public static void main(String[] args) {
        solveEx3();
        solveEx4();
    }
}
