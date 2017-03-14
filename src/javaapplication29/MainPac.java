package javaapplication29;
import java.util.Scanner;
public class MainPac {
    public static void main(String[] args) {
        int x = 1, y = 1,score=0;
        String maze[][] = new String[][]{{"#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
        {"#", "<", "o", " ", " ", " ", " ", " ", " ", "#"},
        {"#", "#", "#", "#", "o", " ", " ", " ", " ", "#"},
        {"#", " ", " ", " ", " ", "#", " ", "#", "#", "#"},
        {"#", " ", "#", " ", " ", "#", "o", " ", " ", "#"},
        {"#", " ", "#", " ", "o", "#", " ", " ", " ", "#"},
        {"#", " ", "#", " ", " ", " ", " ", " ", " ", "#"},
        {"#", "#", "#", " ", " ", " ", "#", "#", "#", "#"},
        {"#", " ", " ", " ", " ", " ", "o", " ", " ", "#"},
        {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#"}};
        Pac pac = new Pac();
        Scanner sc = new Scanner(System.in);
        pac.move();
        String move;
        do {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    System.out.print(maze[i][j]);
                }
                System.out.println("");
            }
            System.out.println("Score     : "+pac.score());
            System.out.println("sisa move : " + pac.move());
            System.out.print("(w,a,s,d untuk pergerakan)>");
            move = sc.nextLine();
            switch (move) {
                case "w":
                    if (maze[y - 1][x].equalsIgnoreCase("#")) {
                        continue;
                    } else {
                        y--;
                        if (maze[y][x].equalsIgnoreCase("o")) {
                            pac.nilai();
                        }
                        maze[y][x] = "v";
                        maze[y + 1][x] = " ";
                        pac.mlaku();
                        break;
                    }
                case "a":
                    if (maze[y][x - 1].equalsIgnoreCase("#")) {
                        continue;
                    } else {
                        pac.mlaku();
                        x--;
                        if (maze[y][x].equalsIgnoreCase("o")) {
                            pac.nilai();
                        }
                        maze[y][x] = ">";
                        maze[y][x + 1] = " ";
                        break;
                    }
                case "s":
                    if (maze[y + 1][x].equalsIgnoreCase("#")) {
                        continue;
                    } else {
                        pac.mlaku();
                        y++;
                        if (maze[y][x].equalsIgnoreCase("o")) {
                            pac.nilai();
                        }
                        maze[y][x] = "^";
                        maze[y - 1][x] = " ";
                        break;
                    }
                case "d":
                    if (maze[y][x + 1].equalsIgnoreCase("#")) {
                        continue;
                    } else {
                        pac.mlaku();
                        x++;
                        if (maze[y][x].equalsIgnoreCase("o")) {
                            pac.nilai();
                        }
                        maze[y][x] = "<";
                        maze[y][x - 1] = " ";
                        break;
                    }
            }
        } while (pac.move() != 0 && !"q".equals(move)&&pac.score()!=5);
        for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    System.out.print(maze[i][j]);
                }
                System.out.println("");
            }
                    if (pac.move()==0 && pac.score()<5) {
                System.out.println("YOU LOSE");
            }else if (pac.score()==5) {
                System.out.println("YOU WIN");
            }
            System.out.println("Score     : "+pac.score());
            System.out.println("sisa move : " + pac.move());
    }
}