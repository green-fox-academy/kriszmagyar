public class Main {

  public static void main(String[] args) {

    PostIt idea = new PostIt("orange", "Idea 1", "blue");
    PostIt awesome = new PostIt("pink", "Awesome", "black");
    PostIt superb = new PostIt("yellow", "Superb", "green");

    BlogPost post1 = new BlogPost("John Doe", "Lorem Ipsum", "Lorem ipsum dolor sit amet.", "2000.05.04");
    BlogPost post2 = new BlogPost("Tim Urban", "Wait but why", "A popular long-form, stick-figure-illustrated blog about almost everything.", "2010.10.10");
    BlogPost post3 = new BlogPost("William Turton", "One Engineer Is Trying to Get IBM to Reckon With Trump", "Daniel Hanley, a cybersecurity engineer at IBM, doesn’t want to be the center of attention. When I asked to take his picture outside one of IBM’s New York City offices, he told me that he wasn’t really into the whole organizer profile thing.", "2017.03.28");

    Animal tiger = new Animal();
    tiger.eat();
    tiger.drink();
    tiger.play();
    System.out.println(tiger.getHunger());
    System.out.println(tiger.getThirst());

    Sharpie sharpie = new Sharpie("black", 50.0);
    sharpie.use();
    System.out.println(sharpie.getInkAmount());

  }

}
