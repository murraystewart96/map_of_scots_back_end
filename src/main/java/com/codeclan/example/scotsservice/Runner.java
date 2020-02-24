//package com.codeclan.example.scotsservice;
//
//// https://github.com/BorderCloud/SPARQL-JAVA
//import com.bordercloud.sparql.Endpoint;
//import com.bordercloud.sparql.EndpointException;
//import java.util.ArrayList;
//import java.util.HashMap;
//
//public class Main {
//
//    public static void main(String[] args) {
//        String endpointUrl = "https://query.wikidata.org/sparql";
//
//        String querySelect = "SELECT DISTINCT ?person ?personLabel ?placeLabel ?coord ?occupationLabel ?genderLabel ?dob ?dod ?image ?sitelink\n" +
//                "  WHERE {\n" +
//                "   ?person wdt:P19 ?place .\n" +
//                "   ?place wdt:P131* wd:Q22 .\n" +
//                "   ?place wdt:P625 ?coord .\n" +
//                "   OPTIONAL {?person wdt:P569 ?dob .}\n" +
//                "   OPTIONAL {?sitelink schema:about ?person; schema:isPartOf <https://en.wikipedia.org/> .}\n" +
//                "   OPTIONAL {?person wdt:P106 ?occupation .}\n" +
//                "   OPTIONAL {?person wdt:P570 ?dod . }\n" +
//                "   OPTIONAL {?person wdt:P21 ?gender .}\n" +
//                "   OPTIONAL {?person wdt:P18 ?image .}\n" +
//                "   OPTIONAL {?sitelink schema:about ?person . ?sitelink schema:inLanguage \"en\"}\n" +
//                "\n" +
//                "   SERVICE wikibase:label {  bd:serviceParam wikibase:language \"[AUTO_LANGUAGE],en\" }\n" +
//                "\n" +
//                " }";
//
//        try {
//            HashMap data = retrieveData(endpointUrl, querySelect);
//            printResult(data, 30);
//        } catch (EndpointException eex) {
//            eex.printStackTrace();
//        }
//    }
//
//    public static HashMap<String, HashMap> retrieveData(String endpointUrl, String query) throws EndpointException {
//        Endpoint sp = new Endpoint(endpointUrl, false);
//        sp.setUserAgentRequestHeader("WDQS-Example Java"); // TODO adjust this; see https://w.wiki/CX6
//        HashMap<String, HashMap> rs = sp.query(query);
//        return rs;
//    }
//
//    public static void printResult(HashMap<String, HashMap> rs , int size) {
//        for (String variable : (ArrayList<String>) rs.get("result").get("variables")) {
//            System.out.print(String.format("%-"+size+"."+size+"s", variable ) + " | ");
//        }
//        System.out.print("\n");
//        for (HashMap value : (ArrayList<HashMap>) rs.get("result").get("rows")) {
//            for (String variable : (ArrayList<String>) rs.get("result").get("variables")) {
//                System.out.print(String.format("%-"+size+"."+size+"s", value.get(variable)) + " | ");
//            }
//            System.out.print("\n");
//        }
//    }
//}
