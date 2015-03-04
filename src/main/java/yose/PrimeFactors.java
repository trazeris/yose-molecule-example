package yose;

import com.google.gson.Gson;
import com.vtence.molecule.Request;
import com.vtence.molecule.Response;
import yose.primefactor.PrimeFactor;

import java.lang.reflect.Array;

import static com.vtence.molecule.http.MimeTypes.JSON;

public class PrimeFactors {

    private final Gson gson;

    public PrimeFactors(Gson gson) {
        this.gson = gson;
    }

    public void powerOfTwoChallenge(Request request, Response response) throws Exception {
       String parameter = request.parameter("number");
       if (parameter== null) {
           response.statusCode(400);
           return;
       }
       try {
            Integer number = Integer.parseInt(parameter);
            response.contentType(JSON).body(gson.toJson(new Decomposition(number)));
       } catch (NumberFormatException e) {
            response.contentType(JSON).body(gson.toJson(new Error(parameter)));
       }
    }
    public static class Decomposition {
        public Integer number = 0;
        public Integer[] decomposition;

        public Decomposition(Integer number) {
            this.number = number;
            decomposition = PrimeFactor.powerOfTwoDecomposition(number);
        }
    }

    public static class Error {
        public String number;
        public String error = "not a number";

        public Error(String number) {
            this.number = number;

        }

    }


}
