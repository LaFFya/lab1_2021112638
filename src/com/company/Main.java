package com.company;

import java.util.*;
import java.io.File;
import static com.company.Method.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filePath;
        while (true) {
            System.out.println("Please enter the file path:");
            filePath = scanner.nextLine();
            File file = new File(filePath);

            if (file.exists()) {
                break;
            } else {
                System.out.println("File does not exist. Please enter a valid file path.");
            }
        }

        //功能1，创建图
        Map<String, Map<String, Integer>> graph = genGraph(filePath);

        //可视化
        while (true) {
            System.out.println("Enter a follower number:");
            System.out.println("1. Show Directed Graph");
            System.out.println("2. Query Bridge Words");
            System.out.println("3. New Text on Bridge Words");
            System.out.println("4. Calculate Shortest Path");
            System.out.println("5. Random Walk");
            int co = scanner.nextInt();
            scanner.nextLine();

            switch (co) {
                case 1:
                    showDirectedGraph(graph);
                    break;
                case 2:
                    System.out.println("Enter word1:");
                    String word1 = scanner.nextLine();
                    System.out.println("Enter word2:");
                    String word2 = scanner.nextLine();
                    System.out.println(queryBridgeWords(graph, word1, word2));
                    break;
                case 3:
                    System.out.println("Enter text:");
                    String inputText = scanner.nextLine();
                    System.out.println(generateNewText(graph, inputText));
                    break;
                case 4:
                    System.out.println("Enter word1:");
                    word1 = scanner.nextLine();
                    System.out.println("Enter word2:");
                    word2 = scanner.nextLine();
                    System.out.println(calcShortestPath(graph, word1, word2));
                    break;
                case 5:
                    randomWalk(graph);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println("Do you want continue? 'yes' or 'no'.");
            String ci = scanner.nextLine();
            if (ci.equals("yes")){

            }
            else{
                scanner.close();
                return;
            }
        }
    }
}