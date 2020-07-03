package com.algorithm.graph;

import java.util.*;

public class ShortestPath {

        public static void main(String[] args) {

            ShortestPath  fp2 = new ShortestPath();
            int c;
            //System.out.println(c);
            String input = "8 \n LON \n JPN  \n LON PAR 6 \n MAD LON 4\n PAR ROM 5 \n ROM JPN 3\n LON OMA 8 \n OMA  BOM 7 \n MAD FRA 7 \n BOM JPN 8";
           System.out.println(fp2.findRoutes(input));
        }

        public  Integer findRoutes(String input) {
            Scanner in = new Scanner(input);
            //in.useDelimiter(";");
            // Read the number of segments
            int N = in.nextInt();
            in.nextLine();
            // Read the origin
            String origin = in.nextLine().trim();
            // Read the destination
            String destination = in.nextLine().trim();
            // Create a List to store the segments
            List<Segment> segmentList = new ArrayList<Segment>();
            // Fill the segments list
            for (int i = 0; i < N; i++) {
                segmentList.add
                        (new Segment(in.nextLine().trim()));
            }

            Map<String,Node> nodeMap = new HashMap<>();
            for(Segment seg : segmentList){
                nodeMap.putIfAbsent(seg.origin,new Node(seg.origin));
                nodeMap.putIfAbsent(seg.destination,new Node(seg.destination));
            }
            Node originNode = nodeMap.get(origin);
            originNode.shortDistance = 0;
            PriorityQueue<Node> nodeQueue = new PriorityQueue<Node>((n1,n2)-> n1.shortDistance.compareTo(n2.shortDistance));

            nodeQueue.add(originNode);

            while(!nodeQueue.isEmpty()){
                Node nextNode = nodeQueue.poll();
                setNextNodes(nextNode,segmentList,nodeQueue, nodeMap);


            }
            return printSegments(nodeMap.get(destination)) ;
    }

    private void setNextNodes(Node originNode,List<Segment>segmentList,
                                 PriorityQueue<Node> nodeQueue,Map<String,Node> nodes) {
            for(Segment seg:segmentList) {
                            if(seg.origin.equals(originNode.name)) {
                                    Node nodeCurrent = nodes.get(seg.destination);
                                    if(originNode.shortDistance + seg.length < nodeCurrent.shortDistance){
                                        nodeCurrent.shortDistance = originNode.shortDistance + seg.length;
                                        nodeCurrent.shortPath= new ArrayList<Segment>();
                                        for(Segment s : originNode.shortPath){
                                            nodeCurrent.shortPath.add(s);
                                        }
                                        nodeCurrent.shortPath.add(seg);
                                    }
                                    nodeQueue.add(nodeCurrent);
                            }
            }
    }


    private int  printSegments(Node dest){
            int  dist = 0;
            StringBuilder sb = new StringBuilder();
            for(Segment seg : dest.shortPath){
                System.out.println(seg.origin + " - " + seg.destination);
                dist += seg.length;
            }
            return dist;
    }





    }


    class Node{
            String name;
            Integer shortDistance = Integer.MAX_VALUE;
            List<Segment> shortPath = new ArrayList<>();

            List<Segment> neighbours;

        public Node(String origin) {
            this.name=origin;
        }
    }


    class Segment {
        String origin;
        String destination;

        public String getDestination() {
            return destination;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }

        public Integer getLength() {
            return length;
        }

        int length;

        public Segment(String input) {
            StringTokenizer st = new StringTokenizer(input);
            origin = st.nextToken();
            destination = st.nextToken();
            length = Integer.parseInt(st.nextToken());
        }

        public boolean equals(Object segment) {
            if (segment instanceof FlightPath2.Segment) {
                FlightPath2.Segment seg = (FlightPath2.Segment) segment;
                return seg.origin.equals(origin) && seg.destination.equals(destination) && seg.length == length;
            }
            return false;
        }

        public String toString() {
            return origin + "->" + destination + " : " + length;
        }

        public int hashCode() {
            int hash = 1;
            hash = hash * 17 + origin.hashCode();
            hash = hash * 31 + destination.hashCode();
            hash = hash * 13 + length;
            return hash;
        }

    }



