package com.example.kirk.webservicetestprojectlib;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import  com.kirk.WebServices.*;

public class MainActivity extends AppCompatActivity {
    TextView txtResults;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtResults = (TextView) findViewById(R.id.txtResults);
    }

    public void call(View v) {
        new AsynCallSoap(1).execute();
    }

    public class AsynCallSoap extends AsyncTask<String, Void, String> {
        private int methodId = 0;

        AsynCallSoap(int methodID) {

            methodId = methodID;

        }

        @Override
        protected String doInBackground(String... params) {
            String responds = "Sorry,did not call  a valid webservice";
            if (methodId == 1) {

                responds =  convert();

                return responds;
            }
            return responds;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            txtResults.setText(result);

        }
        private String callService() {
            String[] servicegenDescription = {"http://", "192.168.43.154", "51051"};

            WebServiceInfo webinfo = new WebServiceInfo(servicegenDescription);

            webinfo.setServiceName("/WebService.asmx");

            webinfo.setSOAP_ACTION("http://tempuri.org/HelloWorld");
            webinfo.setOPERATION_NAME("HelloWorld");
            webinfo.setWSLD_NAMESPACE("http://tempuri.org/");
            webinfo.setSOAP_ADDRESS();

            ServicesMiddleware service = new ServicesMiddleware();
            service.setWebServiceInfo(webinfo);

            String responds = service.callWebService();
            return responds;

        }

        private String callAdd() {

            WebServices webServices = new WebServices();
            ServicesMiddleware service = new ServicesMiddleware();
            service.setWebServiceInfo(webServices.getAddServiceInfo());
            ServicePropertyList propertyList = new ServicePropertyList();
            propertyList.setServiceProperties("p1", 1);
            propertyList.setServiceProperties("p2", 4);



            String responds = service.callWebService(propertyList);
            return responds;

        }

        private String convert() {

            WebServices webServices = new WebServices();
            ServicesMiddleware service = new ServicesMiddleware();
            service.setWebServiceInfo(webServices.getW3SchoolsConvert());
            ServicePropertyList propertyList = new ServicePropertyList();
            propertyList.setServiceProperties("Fahrenheit", Integer.parseInt(((TextView) findViewById(R.id.txtFahrenheit)).getText().toString()));

            String responds = service.callWebService(propertyList);
            return responds;

        }
    }
}
