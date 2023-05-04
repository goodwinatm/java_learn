import java.util.*;


public class Main {
    static String Str_1 = "1. **创建英雄** 当前游戏中，创建英雄角色，定义好对应英雄的血量及其攻击力。";
    static String Str_2 = "2. **查看英雄信息** 查看当前游戏中所有的英雄信息。";
    static String Str_3 = "3. **修改英雄信息** 修改英雄的血量。";
    static String Str_4 = "4. **删除英雄** 英雄太弱，不需要，删除掉。";
    static String Str_5 = "5. **退出系统** 结束程序。";

    static List <Map> li_hero = new ArrayList<>();

    static HashMap create_hero(){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入英雄的名称：");
        String str_name = input.next();
        System.out.println("请输入英雄的血量：");
        String str_blood = input.next();
        System.out.println("请输入英雄的攻击力：");
        String str_power = input.next();
        Map<String,String> hero = new HashMap<>();
        hero.put("name",str_name);
        hero.put("blood",str_blood);
        hero.put("power",str_power);
        return (HashMap) hero;

    }

    static void query_hero(){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入英雄的名称：");
        String str_name = input.next();
        boolean ff = false;
        for(Map hero:li_hero ){
            if (str_name.equalsIgnoreCase((String) hero.get("name"))){
                System.out.println("英雄 " + str_name+ " 的信息为: "+ hero);
                ff = true;
            }
        }

        if (!ff){
            System.out.println("没有英雄 "+ str_name +" 的信息");
        }
    }

    static void update_hero(){
        String str_blood;
        Scanner input = new Scanner(System.in);
        System.out.println("请问你要修改哪个英雄的血量 ");
        String str_name = input.next();
        boolean ff = false;
        for (int i = 0; i<li_hero.size(); i++){
            if (str_name.equalsIgnoreCase((String) li_hero.get(i).get("name"))) {
                System.out.println("请问你要将血量修改为多少？ ");
                str_blood = input.next();
                li_hero.get(i).replace("blood", str_blood);
                ff = true;
                System.out.println("更新之后的结果为 "+ li_hero);
            }
        }
    if (!ff){
            System.out.println("更新之后的结果为没有找到。");
        }
    }
    static void delete_hero(){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入英雄的名称：");
        String str_name = input.next();
        boolean ff = false;
        for(Map hero:li_hero ){
            if (str_name.equalsIgnoreCase((String) hero.get("name"))){
                li_hero.remove(hero);
                ff = true;
                System.out.println("删除之后所有的英雄的数据信息为 "+li_hero);
            }
            break;
        }

        if (!ff){
            System.out.println("没有英雄 "+ str_name +" 的信息");
        }
    }
    public static void main(String[] args) {
        System.out.println(Str_1 + "\n" + Str_2 + "\n" + Str_3 + "\n" + Str_4 + "\n" + Str_5);
        String input = "1";
        String[] array_input = {"1","2","3","4","5"};
        List<String> al = Arrays.asList(array_input);
        Scanner myObj = new Scanner(System.in); // Create a Scanner object
        while (al.contains(input)) {

            System.out.println("请输入数字，选择需要完成的操作：");

            input = myObj.next();  // Read user input
            //System.out.println("Username is: " + userName);  // Output user input

            switch (input) {
                case "1" -> {
                    li_hero.add(create_hero());
                    System.out.println("创建成功");
                }
                case "2" -> query_hero();
                case "3" -> update_hero();
                case "4" -> delete_hero();
                case "5" -> System.out.println("退出系统");
            }
            if (input.equalsIgnoreCase("5")) {
                break;
            }
        }
    }
}