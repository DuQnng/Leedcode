import java.util.Arrays;
import java.util.List;

public class jiangpai {
    public static void main(String[] args) {
        List<Country> countries = Arrays.asList(
                new Country("国家A", "Zebra", 10, 5, 3),   // 英文名 Z 开头
                new Country("国家B", "Apple", 10, 5, 3),   // 英文名 A 开头
                new Country("国家C", "Monkey", 10, 5, 3) // 英文名 M 开头
        );
        countries.sort((a,b)->{
            if(b.total()!=a.total()) return b.total()- a.total();
            if(b.gold!=a.gold) return b.gold-a.gold;
            if(b.silver!= a.silver) return b.silver-a.silver;
            if(b.bronze!=a.bronze) return b.bronze-a.bronze;
            char ca=a.englishName.charAt(0);
            char cb=b.englishName.charAt(0);
            int i=0;
            while (ca!=' '||cb!=' ')
            {
                if(ca!=cb) return ca-cb;
                i++;
                ca=a.englishName.charAt(i);
                cb=b.englishName.charAt(i);
            }
            return 1;
        });
        for (Country c : countries) {
            System.out.println(c.toString());
        }

    }
    static class Country {
        String chineseName;
        String englishName;
        int gold, silver, bronze;

        public Country(String chineseName, String englishName, int gold, int silver, int bronze) {
            this.chineseName = chineseName;
            this.englishName = englishName;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        public int total() {
            return gold + silver + bronze;
        }

        @Override
        public String toString() {
            return "Country{" +
                    "chineseName='" + chineseName + '\'' +
                    ", englishName='" + englishName + '\'' +
                    ", gold=" + gold +
                    ", silver=" + silver +
                    ", bronze=" + bronze +
                    '}';
        }
    }
}
