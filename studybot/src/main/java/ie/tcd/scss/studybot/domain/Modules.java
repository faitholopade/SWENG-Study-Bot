package ie.tcd.scss.studybot.domain;

public class Modules {
    public final static String FORMAT = "[\n" +
    "  {\n" +
    "    \"question\": \"Example Question 1\",\n" +
    "    \"options\": [\"w\", \"x\", \"y\", \"z\"],\n" +
    "    \"answer\": \"Answer from options array\"\n" +
    "  },\n" +
    "  {\n" +
    "    \"question\": \"Example Question 2\",\n" +
    "    \"options\": [\"w\", \"x\", \"y\", \"z\"],\n" +
    "    \"answer\": \"Answer from options array\"\n" +
    "  },\n" +
    "  {\n" +
    "    \"question\": \"Example Question 3\",\n" +
    "    \"options\": [\"w\", \"x\", \"y\", \"z\"],\n" +
    "    \"answer\": \"Answer from options array\"\n" +
    "  },\n" +
    "  {\n" +
    "    \"question\": \"Example Question 4\",\n" +
    "    \"options\": [\"w\", \"x\", \"y\", \"z\"],\n" +
    "    \"answer\": \"Answer from options array\"\n" +
    "  }\n" +
    "]";
    public final static String NETWORKS = "Return the answer in this exact json format, without any explanation or remarks: " + FORMAT + ". Generate an MCQ with 4 questions regarding computer networks. Return the answer so that for each question exactly as the format provide so that, there is a variable question (string), options (array), answer (string from options array).";
    public final static String FUNCTIONAL = "Return the answer in this exact json format, without any explanation or remarks: " + FORMAT + ". Generate an MCQ with 4 questions regarding functional programming. Return the answer so that for each question exactly as the format provide so that, there is a variable question (string), options (array), answer (string from options array).";
    public final static String ARCHITECTURE = "Return the answer in this exact json format, without any explanation or remarks: " + FORMAT + ". Generate an MCQ with 4 questions regarding computer architecture. Return the answer so that for each question exactly as the format provide so that, there is a variable question (string), options (array), answer (string from options array).";
    public final static String SWENG = "Return the answer in this exact json format, without any explanation or remarks: " + FORMAT + ". Generate an MCQ with 4 questions regarding software engineering. Return the answer so that for each question exactly as the format provide so that, there is a variable question (string), options (array), answer (string from options array).";
}
