package modVars;

import modClasses.Construction;

import java.util.ArrayList;

public class Constructions {
    public static Construction siliconFactory,graphiteFactory,metaglassFactory,solidFuelGenerator,
            liquidFactory,fusionReactor,oilFactory,electrolyzer,bigBean;

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
            parse(sf, siliconFactory, ConstructionDicts.siliconFactoryDict);
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
            parse(gf,graphiteFactory, ConstructionDicts.graphiteFactoryDict);
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
            parse(mgf,metaglassFactory, ConstructionDicts.metaglassFactoryDict);
        }
        {
            solidFuelGenerator = new Construction();
            solidFuelGenerator.points = new int[][]{{2,0},{0,2},{5,2},{2,5}};
            String sfg = "ccciccc\n" +
                    "cbbbbbc\n" +
                    "cbbbbbc\n" +
                    "ibbfbbi\n" +
                    "cbbbbbc\n" +
                    "cbbbbbc\n" +
                    "ccciccc";
            solidFuelGenerator.offSet = -3;
            parse(sfg,solidFuelGenerator, ConstructionDicts.solidFuelGeneratorDict);
        }
        {
            liquidFactory = new Construction();
            liquidFactory.points = new int[][]{{1,0},{0,1}};
            String sf = "bbi\n" +
                    "bfb\n" +
                    "obb";
            liquidFactory.offSet = -1;
            parse(sf, liquidFactory, ConstructionDicts.liquidFactoryDict);
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
            parse(of, oilFactory, ConstructionDicts.oilFactoryDict);
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
            parse(fr, fusionReactor, ConstructionDicts.fusionReactorDict);
        }
        {
            electrolyzer = new Construction();
            electrolyzer.points = new int[][]{{0,3},{0,9},{13,6}};
            String el = "fffffmmnmmfffff\n" +
                    "fffmomfffmomfff\n" +
                    "fbmmfffffffmmbf\n" +
                    "fmmffcccccffmmf\n" +
                    "fmfffffffffffmf\n" +
                    "mmftttttttttfmm\n" +
                    "mfffffpppfffffm\n" +
                    "mfccccpfpccccfm\n" +
                    "mfffffpppfffffm\n" +
                    "mmftttttttttfmm\n" +
                    "fmfffffffffffmf\n" +
                    "fmmffcccccffmmf\n" +
                    "ffmmfffffffmmff\n" +
                    "fffmmmfffmmmfff\n" +
                    "fffffmmommfffff\n";
            electrolyzer.offSet = -7;
            parse(el, electrolyzer, ConstructionDicts.electrolyzerDict);
        }
        {
            bigBean = new Construction();
            bigBean.points = new int[][]{{1,0},{2,1},{1,2}};
            String bb = "fot\n" +
                    "vfh\n" +
                    "ise";
            bigBean.offSet = -1;
            parse(bb, bigBean, ConstructionDicts.bigBeanDict);
        }
    }
}
