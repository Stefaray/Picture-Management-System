package domain;

public class AddressMapping {

    public static String userDirMapping(String username){
        return "/imageStore/"+username;
    }

    public static void main(String[] args) {
        System.out.println(userDirMapping("小王"));
    }

}
