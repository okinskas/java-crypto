import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.IntStream;

public class Asg {
    public static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static HashMap<Character, Integer> alphaMap = new HashMap<>();
    public static HashMap<Integer, Character> numMap = new HashMap<>();
    public static HashMap<Character, Double> freqMap = new HashMap<>();
    static {
        IntStream.range(0, ALPHABET.length())
                .forEach(i -> {
                    alphaMap.put(ALPHABET.charAt(i), i);
                    numMap.put(i, ALPHABET.charAt(i));
                });
        freqMap.put('A', 8.167);
        freqMap.put('B', 1.492);
        freqMap.put('C', 2.782);
        freqMap.put('D', 4.253);
        freqMap.put('E', 12.702);
        freqMap.put('F', 2.228);
        freqMap.put('G', 2.015);
        freqMap.put('H', 6.094);
        freqMap.put('I', 6.996);
        freqMap.put('J', 0.153);
        freqMap.put('K', 0.772);
        freqMap.put('L', 4.025);
        freqMap.put('M', 2.406);
        freqMap.put('N', 6.749);
        freqMap.put('O', 7.507);
        freqMap.put('P', 1.929);
        freqMap.put('Q', 0.095);
        freqMap.put('R', 5.987);
        freqMap.put('S', 6.327);
        freqMap.put('T', 9.056);
        freqMap.put('U', 2.758);
        freqMap.put('V', 0.978);
        freqMap.put('W', 2.460);
        freqMap.put('X', 0.150);
        freqMap.put('Y', 1.974);
        freqMap.put('Z', 0.074);
    }

    private static String ex4 = "FVLYICQURFHQOCPCNRFBLPRCQGIJGCYCBMKHYAMFWKALLNPBPVIEEQXEOBKOWVNPBZYEWLOBFYHYSFYVHYGCPMCGGIFSFYVHYFFBLOCCXNOQLLNOKNBWDVLDNRVQEYRNBMODUGPUBZJFARGJVLYHLABOEUXCCGREYWBKBHDNDQYBFNBUUVLDVOACXNRUCOBKAEFHQGYFFYSFXCBGFBSYHLDYBQYFLIZYFXCVLZFEQGKADRQPVBRYHZKFRBXGVRENRRGOBKVPIIYFCLHCHLAUIZMOHSAEPVOSMOYLHGIXSAEFNECCUNBNFFARSMOUDGCKXSAEZBEEAEUCGWIYDUCVWYHJAHYGYAIZGUEYXZGIESAETCDUREYSEFBUNFYDUSAQQNRRALQCVDPBOUYAMKVBVYCVLPNONBLZXBFBQYHJABKICHCCFCABOEGQBKQCSCNRLQFIOCBHRVQFHDRLQCYAZRNRRPAYDRPJCXRBKYQNRFPOQCQYBECABSFQZLECSIIEFFBUBGREYSEALHNVRFIXBDAIWVAFFSNPVWYZPXXOFFFJZHREYBNQQBOJMJUXGMPOMUBFMKQTXHDNEBVIVRPYXSMOWOQGKNOEALOBFCQBKGFBZOYRFNEADXCBGMEYBGMBROEAFMONLVJBRQPOBRMCVVNLACCUKBHDJFFWRUCJCQUREUFRFLHOFRISOZNIIIRBEUNFFBVORLYYDGCOULYCQIKIMFXRVKEYBRJBUCRBEYBZMJYXGYOCVLGJJBVQLHOQUXCCGYKXGVREBOYBQBOXGPMSGYIFDHPKYNBLQBKGPBFONQBQRNREUNTGSYXUCOMDECKADURL";
    private static String ex7 = "JTWAPYCAJTLCQPQWACYAQPCQNACJQAZTCQAFJXRQAPYAXPCNHWQNAFTLAXPACJQAFTDAPYFAWNYEEQWAXPABHXMURDATPWALYYPACJQAMYHERQLAKQMTSQARQTVQPQWAFXCJANHLCXMADYHCJACYATASTNUQWAQICQPCACXRRATCARQPZCJACJQAERTXPQLCAFYSTPAXPACJQAMRHKAFTLAPYARYPZQNAMYSEQRRQWACYAGYYCAXCAYPACJQASTLMHRXPQALXWQAYGACJQAGXZHNQACJQAMJHNMJAMRYMUALCNHMUAFJQPALHWWQPRDACJQALCHWQPCALTXWACJTCAJQASHLCARQTVQAJQAJTWAKQQPAGYNZQCCXPZAJXSLQRGAJQAJTWACYAOYXPAJXLAMYSETPXYPLATLAJQAGQRRAYHCAYGACJQAWTPMQAJXLAQDQLARXZJCQWAYPACQLLAWHNKQDGXQRWAFJYLQAYFPARTNZQAYNKLAFYNQACYACQRRACJQACNHCJACJQAGTXPCQLCATLEQMCAYGANQENYTMJACJTCAJQAJTWAPYCAMJYLQPAJQNAJQACYYAFTLALYNNDACJQPACJTCAYFXPZACYAJQNAKTMUFTNWPQLLAJQAJTWAPYCAYKLQNVQWAJQNATPWAFXCJACJTCAXPAJXLASXPWAJQARQGCACJQAETLCHNQAYPATMMYHPCAYGAJXLARYPZAWQRTDAJQALCTNCQWAXPATAGRDXPZANHPAWYFPACJQARTPQAFQLCFTNWATPWAJTWALYYPAETLLQWACJQAJYRRYFATPWASYHPCQWACJQAPQICAN";

    public static void main(String[] args) {
//        iteratePossibleTranspositions();
//        solveEx7();
         solveEx4();

//        String s = "domdowwynvuwdwndwajzlpshtzazbztpywvqzxjititegfgykglzqaxsbfwccbcwoomtjjoideqdppxyaooaxgzcpydwdposkocnumdddazcjntahacfmpdwsithcwttsizmenodprai".toUpperCase();
//        var map = getFrequencyMap(s);
//        printFrequencyMap(map);

//        String s = "kqokhalkhnmvggbeewmcuaozxdqaxtzbeeagxeecqqdaxgloxrbenwdfbzhwzqatquxumwgbzamnppmcqqpadeqkhvmoexnfawuwpzpydfleiamjebeemducxldtaffkbfxfhxjmqrlc";
//        iteratePossibleCaesars(s);
    }

    public static void solveEx4() {
        String[] cols = decryptVigenere(ex4, 6);
        for (String s : cols) {
            System.out.println(s);

            double[] d = getFrequencyArray(s);
            evaluateFrequencies(d);

//            HashMap<Character, Double> frequencies = getFrequencyMap(s);
//            printFrequencyMap(frequencies);
//            int i = getVigenereCharPrediction(frequencies);
//            System.out.println(i);
        }
//        decryptVigenere(ex4, 6);
    }

    public static String[] decryptVigenere(String s, int keyLen) {

        String[] cols = new String[keyLen];
        for (int i = 0; i < keyLen; i++) {
            cols[i] = "";
            for (int j = i; j < s.length(); j += keyLen) {
                cols[i] += s.charAt(j);
            }
        }
//        for (String sub : cols) {
//            System.out.println(sub);
//        }
        return cols;
    }

    public static void iteratePossibleCaesars(String s) {
        s = s.toUpperCase();
        String[] shifts = new String[ALPHABET.length()];
        for (int i = 0; i < ALPHABET.length(); i++) {
            StringBuilder out = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                int val = (alphaMap.get(s.charAt(j)) + i) % ALPHABET.length();
                out.append(numMap.get(val));
            }
            shifts[i] = out.toString();
        }

        for (String current : shifts) {
            System.out.println(current);
            HashMap m = getOccurrenceMap(current);
            //evaluateFrequencies(d);

//            HashMap<Character, Double> frequencies = getFrequencyMap(s);
//            printFrequencyMap(frequencies);
//            int i = getVigenereCharPrediction(frequencies);
//            System.out.println(i);
        }
    }

    public static void iteratePossibleTranspositions() {
        String[] strings = new String[]{
                "VWBOHFNIEEUODNANRNENIUHETSTABTODEOAUIYTIORENTAMOAHARINTMELTEUOIEDTATOBSNDURFOIOCNSISIBIEHHNDICITEARTOWINTONTRSNBTNOIIREDIVOGSTNOIUBSTEECIAMT",
                "RLKCVORERHLCOEOTUINICRTSHGIYTITEHTEBLHASNPTOOLSRISDJTTCIEDEOEIDFAIDHTTOBWINSBIGKRAEUNICNRPTNPUNIBHPTMSIPNATRSISSTTHCUDFNLRTDEOHEYDOTRALASRRY",
                "TLIOEUINOEIENDWOSVTNEOHTERCORDHOAHOEEATISEHRNATROAMIOELNIYNWNTUISNIIHSTEEOCNTNSIMYTEWNUEOAITRPTTRATHAANPISHEHCHUAIEOEUIDBYHOWBEFSNNIMNAIAAIF",
                "EEEAEYTNDDBICULEHDEKNBTWTARDYRNGCFMRLWHDHEDFITUUTENOSDOKRAHNMNDYPRMTFUNGENAUULNEODLQOESDEEOIRCOLAMEOOATOUFGONRDEOOTDNSYALEDIEWCNLLEIESLLNBBL",
                "WITNANDDSPRCATITHBEHGYUEHREHUAGETSEFRHTSRHAEMTDBENIYCSSATSOAYTSREOGDNAHHSARHOHGINAWHSAGSIFICHEAHTADIENWGOTKETEHERKCMNDRETEGINHRSAHOVNSDLMIHG",
                "ESOTCIOEHPPVNINOEABISOGNAEALTNEEHENDVESAJETIAHYELSDPKESIHAFMOIABLNHNKTEIIJBODALNGNHITSDSTTREEOTALHCNRDAARYIMUIADEEEATMBLWAONTYAOMOTIGYWLKDAH"
        };

        for (int i = 0; i < 6; i++) {
            int j = i;

            do {
                System.out.println(strings[j]);
                j++;
                if (j >= 6) {
                    j = 0;
                }

            } while (j != i);

            System.out.println();
        }
    }

    public static void decryptTransposition() {
        String in = "TLIOEUINOEIENDWOSVTNEOHTERCORDHOAHOEEATISEHRNATROAMIOELNIYNWNTUISNIIHSTEEOCNTNSIMYTEWNUEOAITRPTTRATHAANPISHEHCHUAIEOEUIDBYHOWBEFSNNIMNAIAAIFVWBOHFNIEEUODNANRNENIUHETSTABTODEOAUIYTIORENTAMOAHARINTMELTEUOIEDTATOBSNDURFOIOCNSISIBIEHHNDICITEARTOWINTONTRSNBTNOIIREDIVOGSTNOIUBSTEECIAMTESOTCIOEHPPVNINOEABISOGNAEALTNEEHENDVESAJETIAHYELSDPKESIHAFMOIABLNHNKTEIIJBODALNGNHITSDSTTREEOTALHCNRDAARYIMUIADEEEATMBLWAONTYAOMOTIGYWLKDAHRLKCVORERHLCOEOTUINICRTSHGIYTITEHTEBLHASNPTOOLSRISDJTTCIEDEOEIDFAIDHTTOBWINSBIGKRAEUNICNRPTNPUNIBHPTMSIPNATRSISSTTHCUDFNLRTDEOHEYDOTRALASRRYWITNANDDSPRCATITHBEHGYUEHREHUAGETSEFRHTSRHAEMTDBENIYCSSATSOAYTSREOGDNAHHSARHOHGINAWHSAGSIFICHEAHTADIENWGOTKETEHERKCMNDRETEGINHRSAHOVNSDLMIHGEEEAEYTNDDBICULEHDEKNBTWTARDYRNGCFMRLWHDHEDFITUUTENOSDOKRAHNMNDYPRMTFUNGENAUULNEODLQOESDEEOIRCOLAMEOOATOUFGONRDEOOTDNSYALEDIEWCNLLEIESLLNBBL";
        int inLength = in.length() / 6;

        ArrayList<StringBuilder> stringBuilders = new ArrayList<>();
        stringBuilders.add(new StringBuilder());
        stringBuilders.add(new StringBuilder());
        stringBuilders.add(new StringBuilder());
        stringBuilders.add(new StringBuilder());
        stringBuilders.add(new StringBuilder());
        stringBuilders.add(new StringBuilder());

        int j = 0;
        for (int i = 0; i < in.length(); i += inLength) {
            if (j >= 6) j = -1;
            j++;

            String sub = in.substring(i, i + inLength);
            stringBuilders.get(j).append(sub);
        }

        for (StringBuilder builder : stringBuilders) {
            System.out.println(builder.toString());
        }
    }

    public static void solveEx7() {

        HashMap<Character, Integer> frequencyMap = getOccurrenceMap(ex7);
        //printFrequencyMap(frequencyMap);

        HashMap<Character, Character> replacements = new HashMap<>();
        replacements.put('A', '|');
        replacements.put('B', 'q');
        replacements.put('C', 't');
        replacements.put('D', 'y');
        replacements.put('E', 'p');
        replacements.put('F', 'w');
        replacements.put('G', 'f');
        replacements.put('H', 'u');
        replacements.put('I', 'x');
        replacements.put('J', 'h');
        replacements.put('T', 'a');
        replacements.put('Q', 'e');
        replacements.put('Y', 'o');
        replacements.put('P', 'n');
        replacements.put('X', 'i');
        replacements.put('W', 'd');
        replacements.put('R', 'l');
        replacements.put('N', 'r');
        replacements.put('Z', 'g');
        replacements.put('S', 'm');
        replacements.put('K', 'b');
        replacements.put('L', 's');
        replacements.put('M', 'c');
        replacements.put('U', 'k');
        replacements.put('V', 'v');
        replacements.put('O', 'J');

        System.out.println(substitute(ex7, replacements));
    }

    public static String substitute(String s, HashMap<Character, Character> dict) {

        for (Character c : dict.keySet()) {
            s = s.replace(c, dict.get(c));
        }
        s = s.toUpperCase();

        return s;
    }

    public static HashMap<Character, Integer> getOccurrenceMap(String s) {
        HashMap<Character, Integer> frequencies = new HashMap<>();

        for (Character c : s.toCharArray()) {
            int count = frequencies.getOrDefault(c, 0);
            frequencies.put(c, count + 1);
        }

        for (Character c : frequencies.keySet()) {
            StringBuilder current = new StringBuilder();
            current.append(c)
                    .append(": ")
                    .append(frequencies.getOrDefault(c, 0))
                    .append(" -- ")
                    .append((freqMap.get(c) / 100 ) * s.length());

            System.out.println(current);
        }
        return frequencies;
    }

    public static double[] getFrequencyArray(String s) {
        HashMap<Character, Integer> occurrenceMap = getOccurrenceMap(s);
        double[] frequencies = new double[ALPHABET.length()];

        int total = 0;
        for (Integer i :occurrenceMap.values()) {
            total += i;
        }

        for (int i = 0; i < ALPHABET.length(); i++) {
            double occurrenceOverTotal = (double) occurrenceMap.getOrDefault(ALPHABET.charAt(i), 0) / (double) total;
            frequencies[i] = occurrenceOverTotal * 100;
            System.out.println(frequencies[i]);
        }
        return frequencies;
    }

    public static void evaluateFrequencies(double[] frequencies) {
        HashMap<Integer, Double> shifts = new HashMap<>();

        for (int i = 0; i < frequencies.length; i++) {
            double totalDiff = 0;
            int k = 0;
            for (int j = i; j < i + 26; j++) {
                Character currentChar = numMap.get(k);
                double currentDiff = frequencies[j % 26] - freqMap.get(currentChar);
                totalDiff += currentDiff < 0 ? currentDiff * -1 : currentDiff;
                k++;
            }
            shifts.put(i, totalDiff);
            System.out.println(i + ": " + totalDiff);
        }
    }

    public static HashMap<Character, Double> getFrequencyMap(String s) {
        HashMap<Character, Integer> occurrenceMap = getOccurrenceMap(s);
        HashMap<Character, Double> frequencies = new HashMap<>();

        int total = 0;
        for (Integer i :occurrenceMap.values()) {
            total += i;
        }
        for (Character c : occurrenceMap.keySet()) {
            frequencies.put(c, ((double) occurrenceMap.get(c) / total) * 100);
        }

        return frequencies;
    }

    public static int getVigenereCharPrediction(HashMap<Character, Double> frequencies) {
        HashMap<Integer, Double> diffMap = new HashMap<>();
        int currentShift = 0;
        for (int i = 0; i < ALPHABET.length(); i++) {
            double diffTotal = 0;
            for (Character c : frequencies.keySet()) {
                double diff = frequencies.get(c) - freqMap.get(c);
                diffTotal += diff >= 0 ? diff : diff * -1;
            }
            diffMap.put(i, diffTotal);
        }
        double lowestDiff = Integer.MAX_VALUE;
        for (Integer i : diffMap.keySet()) {
            System.out.println(i + ": " + diffMap.get(i));
            if (diffMap.get(i) < lowestDiff) {
                lowestDiff = diffMap.get(i);
                currentShift = i;
            }
        }
        return currentShift;
    }

    public static void printFrequencyMap(HashMap<Character, Double> frequencies) {
        StringBuilder output = new StringBuilder();
        int total = 0;
        for (Double i :frequencies.values()) {
            total += i;
        }
        for (Character c : frequencies.keySet()) {
            output.append(c).append(": ").append(frequencies.get(c)).append("\n");
        }
        System.out.println(output);
    }
}

/*

TLIOEUINOEIENDWOSVTNEOHTERCORDHOAHOEEATISEHRNATROAMIOELNIYNWNTUISNIIHSTEEOCNTNSIMYTEWNUEOAITRPTTRATHAANPISHEHCHUAIEOEUIDBYHOWBEFSNNIMNAIAAIF
VWBOHFNIEEUODNANRNENIUHETSTABTODEOAUIYTIORENTAMOAHARINTMELTEUOIEDTATOBSNDURFOIOCNSISIBIEHHNDICITEARTOWINTONTRSNBTNOIIREDIVOGSTNOIUBSTEECIAMT
ESOTCIOEHPPVNINOEABISOGNAEALTNEEHENDVESAJETIAHYELSDPKESIHAFMOIABLNHNKTEIIJBODALNGNHITSDSTTREEOTALHCNRDAARYIMUIADEEEATMBLWAONTYAOMOTIGYWLKDAH
RLKCVORERHLCOEOTUINICRTSHGIYTITEHTEBLHASNPTOOLSRISDJTTCIEDEOEIDFAIDHTTOBWINSBIGKRAEUNICNRPTNPUNIBHPTMSIPNATRSISSTTHCUDFNLRTDEOHEYDOTRALASRRY
WITNANDDSPRCATITHBEHGYUEHREHUAGETSEFRHTSRHAEMTDBENIYCSSATSOAYTSREOGDNAHHSARHOHGINAWHSAGSIFICHEAHTADIENWGOTKETEHERKCMNDRETEGINHRSAHOVNSDLMIHG
EEEAEYTNDDBICULEHDEKNBTWTARDYRNGCFMRLWHDHEDFITUUTENOSDOKRAHNMNDYPRMTFUNGENAUULNEODLQOESDEEOIRCOLAMEOOATOUFGONRDEOOTDNSYALEDIEWCNLLEIESLLNBBL

TLIOEUINOEIENDWOSVTNEOHTERCORDHOAHOEEATISEHRNATROAMIOELNIYNWNTUISNIIHSTEEOCNTNSIMYTEWNUEOAITRPTTRATHAANPISHEHCHUAIEOEUIDBYHOWBEFSNNIMNAIAAIF
RLKCVORERHLCOEOTUINICRTSHGIYTITEHTEBLHASNPTOOLSRISDJTTCIEDEOEIDFAIDHTTOBWINSBIGKRAEUNICNRPTNPUNIBHPTMSIPNATRSISSTTHCUDFNLRTDEOHEYDOTRALASRRY
ESOTCIOEHPPVNINOEABISOGNAEALTNEEHENDVESAJETIAHYELSDPKESIHAFMOIABLNHNKTEIIJBODALNGNHITSDSTTREEOTALHCNRDAARYIMUIADEEEATMBLWAONTYAOMOTIGYWLKDAH
WITNANDDSPRCATITHBEHGYUEHREHUAGETSEFRHTSRHAEMTDBENIYCSSATSOAYTSREOGDNAHHSARHOHGINAWHSAGSIFICHEAHTADIENWGOTKETEHERKCMNDRETEGINHRSAHOVNSDLMIHG
EEEAEYTNDDBICULEHDEKNBTWTARDYRNGCFMRLWHDHEDFITUUTENOSDOKRAHNMNDYPRMTFUNGENAUULNEODLQOESDEEOIRCOLAMEOOATOUFGONRDEOOTDNSYALEDIEWCNLLEIESLLNBBL
VWBOHFNIEEUODNANRNENIUHETSTABTODEOAUIYTIORENTAMOAHARINTMELTEUOIEDTATOBSNDURFOIOCNSISIBIEHHNDICITEARTOWINTONTRSNBTNOIIREDIVOGSTNOIUBSTEECIAMT

 */