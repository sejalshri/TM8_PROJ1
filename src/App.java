import java.util.*;
class Video{
    String title;
    HashMap<String,Integer> flag=new HashMap<>();
    HashMap<String,Integer> Rating=new HashMap<>();
    void checked(String str){
        System.out.println(str+" is checked out.");
    }
    void returned(String str){
        if(flag.get(str)==0){
            System.out.println(str+" is returned.");
        }
        else{
            System.out.println(str+" is not returned.");
        }
    }
    void rating(String str){
        System.out.println(str+" rating has been updated ! ");
    }
}
class VideoStore extends Video{
    ArrayList<String> videos=new ArrayList<>();
    int total=0;
    void addVideo(String title){
        videos.add(title);
        flag.put(title,0);
        Rating.put(title, 0);
        System.out.println(title+" added successfully!");
    }
    void checkOut(String title){
        if(flag.containsKey(title)==false){
            System.out.println("No such video found!");
            return;
        }
        videos.remove(new String(title));
        flag.put(title,1);
        checked(title);
    }
    void returnVideo(String title){
        if(flag.get(title)==0){
            System.out.println(title+" has not been rented!");
            return;
        }
        videos.add(title);
        flag.put(title,0);
        returned(title);
    }
    void receiveRating(String title,int rating){
        if(flag.containsKey(title)==false){
            System.out.println("No such video found!");
            return;
        }
        Rating.replace(title, Rating.get(title), Rating.get(title)+rating);
        rating(title);
    }
    void listInventory(){
        for(int i=0;i<videos.size();i++){
            System.out.println(videos.get(i)+" : "+Rating.get(videos.get(i))+" stars");
        }
    }
}
public class App {
    public static void main(String[] args) throws Exception {
        Scanner input=new Scanner(System.in);
        VideoStore obj=new VideoStore();
        int choice;
        do {
            System.out.println("MAIN MENU \n=========");
            System.out.println("1. Add Videos:");
            System.out.println("2. Check Out Video:");
            System.out.println("3. Return Video:");
            System.out.println("4. Receive Rating:");
            System.out.println("5. List Inventory and their ratings:");
            System.out.println("6. Exit:");
            System.out.print("Enter your choice(1..6): ");
            
            choice=input.nextInt();
            switch (choice) {
            case 1:
                System.out.println("Enter the name of the video you want to add: ");
                obj.addVideo(input.next());
                break;
            case 2:
                System.out.print("Enter the name of the video you want to check out: ");
                obj.checkOut(input.next());
                break;
            case 3:
                System.out.print("Enter the name of the video you want to Return:");
                obj.returnVideo(input.next());;
                break;
            case 4:
                System.out.println("Enter the name of the video you want to Rate: ");
                obj.receiveRating(input.next(), input.nextInt());
                break;
            case 5:
                obj.listInventory();
                break;
            case 6:
                System.err.println("Thanks for using the application");
                System.exit(1);
                break;
            }
    }
    while(!(choice==6));	
    input.close();	
    }
}
