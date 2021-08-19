package modVars;

import modClasses.Construction;

import java.util.ArrayList;

public class Constructions {
    public static Construction siliconFactory,graphiteFactory,metaglassFactory,solidFuelGenerator,
            liquidFactory,fusionReactor,oilFactory;

    public static void parse(String str,Construction cons,String[][] list){
        int z = 0;
        cons.data.add(new ArrayList<String>());
        for(int i = 0;i < str.length();i++){
            String symbol = str.substring(i,i+1);
            if(symbol.equals("\n")){
                z += 1;
                cons.data.add(new ArrayList<String>());
            }else{
                for(int ind = 0;ind < list.length;ind++){
                    if(symbol.equals(list[ind][0])){
                        symbol = list[ind][1];
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
            parse(sf, siliconFactory, ConstructionDicts.siliconFactory);
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
            parse(gf,graphiteFactory, ConstructionDicts.graphiteFactory);
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
            parse(mgf,metaglassFactory, ConstructionDicts.metaglassFactory);
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
            parse(sfg,solidFuelGenerator, ConstructionDicts.solidFuelGenerator);
        }
        {
            liquidFactory = new Construction();
            String sf = "bbi\n" +
                    "bfb\n" +
                    "obb";
            liquidFactory.offSet = -1;
            parse(sf, liquidFactory, ConstructionDicts.liquidFactory);
        }
        {
            oilFactory = new Construction();
            oilFactory.points = new int[][]{{1,1},{4,1},{4,1},{5,1},{4,3},{4,4}};
            String of = "ftttt\n" +
                    "flppt\n" +
                    "ftbpt\n" +
                    "fitfq\n" +
                    "fitno\n" +
                    "ftbpt\n" +
                    "flppt\n" +
                    "ftttt";
            oilFactory.offSet = -3;
            parse(of, oilFactory, ConstructionDicts.oilFactory);
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
            parse(fr, fusionReactor, ConstructionDicts.fusionReactor);
        }
    }
}
