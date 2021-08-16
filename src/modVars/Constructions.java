package modVars;

import arc.util.Log;
import modClasses.Construction;

import java.util.ArrayList;

public class Constructions {
    public static Construction siliconFactory,graphiteFactory,metaglassFactory,solidFuelGenerator,liquidFactory,fusionReactor;

    public static void parse(String str,Construction cons,ArrayList<ArrayList<String>> list){
        int z = 0;
        cons.data.add(new ArrayList<String>());
        for(int i = 0;i < str.length();i++){
            String symbol = str.substring(i,i+1);
            if(symbol.equals("\n")){
                z += 1;
                cons.data.add(new ArrayList<String>());
            }else{
                for(int ind = 0;ind < list.size();ind++){
                    if(symbol.equals(list.get(ind).get(0))){
                        symbol = list.get(ind).get(1);
                    }
                }
                cons.data.get(z).add(symbol);
            }
        }
    }

    public static void init(){
        {
            siliconFactory = new Construction();
            siliconFactory.points = new int[][]{{0,0},{0,2},{2,0}};
            String sf = "ibi\n" +
                    "bfb\n" +
                    "obb";
            siliconFactory.offSet = -1;
            parse(sf, siliconFactory, ConstructionDicts.standartCode);
        }
        {
            graphiteFactory = new Construction();
            graphiteFactory.points = new int[][]{{0,2},{4,2}};
            String gf = "fbibf\n" +
                    "bfffb\n" +
                    "bfffb\n" +
                    "bfffb\n" +
                    "fbobf\n";
            graphiteFactory.offSet = -2;
            parse(gf,graphiteFactory, ConstructionDicts.standartCode);
        }
        {
            metaglassFactory = new Construction();
            metaglassFactory.points = new int[][]{{2,0},{4,0},{6,3}};
            String mgf = "fffcfff\n" +
                    "ffbbbff\n" +
                    "ibfffbf\n" +
                    "cbfffbo\n" +
                    "ibfffbf\n" +
                    "ffbbbff\n" +
                    "fffсfff";
            metaglassFactory.offSet = -3;
            parse(mgf,metaglassFactory, ConstructionDicts.standartCode);
        }
        {
            solidFuelGenerator = new Construction();
            String sfg = "ccciccc\n" +
                    "cbbbbbc\n" +
                    "cbbbbbc\n" +
                    "ibbfbbi\n" +
                    "cbbbbbc\n" +
                    "cbbbbbc\n" +
                    "ccciccc";
            solidFuelGenerator.offSet = -3;
            parse(sfg,solidFuelGenerator, ConstructionDicts.standartCode);
        }
        {
            liquidFactory = new Construction();
            String sf = "bbl\n" +
                    "bfb\n" +
                    "hbb";
            liquidFactory.offSet = -1;
            parse(sf, liquidFactory, ConstructionDicts.standartCode);
        }
        {
            fusionReactor = new Construction();
            fusionReactor.points = new int[][]{{0,13},{26,13},{13,26}};
            String fr = "fffffffffffffifffffffffffff\n" +
                    "ffffffffffttfffttffffffffff\n" +
                    "fffffffttttpppppttttfffffff\n" +
                    "ffffftttpppptttpppptttfffff\n" +
                    "ffffttpppttttwttttpppttffff\n" +
                    "fffttpptttffwwwfftttppttfff\n" +
                    "ffftppttfffffwfffffttpptfff\n" +
                    "ffttpttffffffwffffffttpttff\n" +
                    "fftpptfffffffwffffffftpptff\n" +
                    "fftpttfffffffwfffffffttptff\n" +
                    "fttptffffffffwfffffffftpttf\n" +
                    "ftpptfffffffwwwffffffftpptf\n" +
                    "ftpttwfffffwfffwfffffwttpff\n" +
                    "ftntwwwwwwwwfffwwwwwwwwtpfo\n" +
                    "ftpttwfffffwfffwfffffwttpff\n" +
                    "ftpptfffffffwwwffffffftpptf\n" +
                    "fttptffffffffwfffffffftpttf\n" +
                    "fftpttfffffffwfffffffttptff\n" +
                    "fftpptfffffffwffffffftpptff\n" +
                    "ffttpttffffffwffffffttpttff\n" +
                    "ffftppttfffffwfffffttpptfff\n" +
                    "fffttpptttffwwwfftttppttfff\n" +
                    "ffffttpppttttwttttpppttffff\n" +
                    "ffffftttpppptttpppptttfffff\n" +
                    "fffffffttttpppppttttfffffff\n" +
                    "ffffffffffttfffttffffffffff\n" +
                    "fffffffffffffifffffffffffff\n" +
                    "fffffffffffffffffffffffffff";
            fusionReactor.offSet = -13;
            parse(fr, fusionReactor, ConstructionDicts.standartCode);
        }
    }
}
