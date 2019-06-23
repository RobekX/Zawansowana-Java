package model.utils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

//RESTful Web Serviced client app
public class Currency {
    String downloadJson;
    Double rateValue;
    public Double getRateValue(CurrencyCode currencyCode){
        try{
            Client client = Client.create();
            WebResource webResource = client.resource("http://api.nbp.pl/api/exchangerates/rates/a/"+currencyCode);
            ClientResponse webResponse = webResource.accept("application/json").get(ClientResponse.class);

            if(webResponse.getStatus() !=200){
                throw  new RuntimeException("HTTP error..." + webResponse.getStatus());
            }

            downloadJson = webResponse.getEntity(String.class);

            //Jersey REST client
            //use Jackson 2
            ObjectMapper mapper = new ObjectMapper();
            ExchangeRate exchangeRate = mapper.readValue(downloadJson, ExchangeRate.class);
            rateValue=exchangeRate.getRates().get(0).getMid();

        }catch (Exception e){
            e.printStackTrace();
        }
        return rateValue;
    }





}
