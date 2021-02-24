package Compulsory;

import sun.security.krb5.internal.crypto.Des;

public class Main {

    public static void main(String[] args) {

        Problem problem = new Problem();

        Source s1 = new Source("s1", SourceType.FACTORY);
        System.out.println(s1);

        Source s2 = new Source("S2", SourceType.WAREHOUSE);
        System.out.println(s2);

        Source s3 = new Source("S3", SourceType.WAREHOUSE);
        System.out.println(s3);

        Destination d1 = new Destination("D1");
        System.out.println(d1);

        Destination d2 = new Destination("D2");
        System.out.println(d2);

        Destination d3 = new Destination("D3");
        System.out.println(d3);

        problem.setSources(new Source[]{s1, s2, s3});
        problem.setDestinations(new Destination[]{d1, d2, d3});
        problem.setSupply(new int[]{10, 35, 25});
        problem.setDemand(new int[]{20, 25, 25});
        problem.setCost(new int[][]{
                {2, 3, 1},
                {5, 4, 8},
                {5, 6, 8}
        });
        problem.getCost();

        System.out.println(problem);


    }
}
