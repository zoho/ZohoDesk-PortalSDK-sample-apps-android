package com.ticketfield.ticket_field_configuration_sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.zoho.desk.asap.api.ZDPortalCallback;
import com.zoho.desk.asap.api.ZDPortalException;
import com.zoho.desk.asap.api.ZDPortalTicketsAPI;
import com.zoho.desk.asap.api.response.Ticket;
import com.zoho.desk.asap.api.response.TicketField;
import com.zoho.desk.asap.api.response.TicketFieldsList;
import com.zoho.desk.asap.api.response.TicketStatusMapping;
import com.zoho.desk.asap.asap_tickets.ZDPortalSubmitTicket;
import com.zoho.desk.asap.asap_tickets.utils.PreFillTicketField;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> listTobeShown = new ArrayList<>();
    String closedStatus = "Closed";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getTicketFields();
    }

    private void getTicketFields() {

        HashMap<String, String> params = new HashMap<>();
        params.put("departmentId", "deptId");
        ZDPortalTicketsAPI.getTicketFields(fieldsCallback, params, "apiName");
    }

    public void  configureListToBeShown(View view) {

        listTobeShown.add("field api name"); /* replace your field api name*/
        listTobeShown.add("field api name"); /* replace your field api name. Field API name can be found through, ticket fields API.*/
        ZDPortalSubmitTicket.setTicketsFieldsListTobeShown(listTobeShown);
        /*If the ASAP is configured for single department, department id is opitonal. Else, the department id is mandatory*/
        ZDPortalSubmitTicket.setTicketsFieldsListTobeShown(listTobeShown, "departmentId");
    }

    public void configureValuesToFields(View view) {
        List<PreFillTicketField> preFillTicketFiledList = new ArrayList<>();
        Object fieldValue = "ticket field value";
        boolean iseditable = true;
        preFillTicketFiledList.add(new PreFillTicketField("field api name", fieldValue, iseditable));
        preFillTicketFiledList.add(new PreFillTicketField("field api name", fieldValue, iseditable));
        ZDPortalSubmitTicket.preFillTicketFields(preFillTicketFiledList);
        /*If the ASAP is configured for single department, department id is opitonal. Else, the department id is mandatory*/
        ZDPortalSubmitTicket.preFillTicketFields(preFillTicketFiledList, "departmentId");

        /* replace your field api name. Field API name can be found through, ticket fields API.*/
        /*
        *   fieldValue - object
            For multiselect fields, pass the values allowed, as a list of strings. List<String>
            For pick list fields, pass one of the values allowed, as a string.
            For date fields, pass the value as a string in the dd-MM-yyyy format.
            For dateTime fields, pass the value as a string in the dd-MM-yyyy HH:mm a format.
            For Boolean fields, pass a Boolean value.
            For all other field types, pass the values as string objects.
            Make sure that the values you pass adhere to the maxlength and decimal restrictions defined for the field.
        *
        * */

    }

    public void submitTicket(View view) {
        ZDPortalSubmitTicket.show(this);
    }

    private ZDPortalCallback.TicketFieldsCallback fieldsCallback = new ZDPortalCallback.TicketFieldsCallback() {
        @Override
        public void onTicketFieldsDownloaded(TicketFieldsList ticketFieldsList) {
            for(TicketField fieldResponse:ticketFieldsList.getData()) {
                listTobeShown.add(fieldResponse.getApiName());
                //populate the list listTobeShown for the field that needs to be shown in the Submit Ticket module
            }

        }

        @Override
        public void onException(ZDPortalException e) {

        }
    };

    public void updateTicketStatus() {
        String ticketId = "";

        HashMap<String, Object> ticketValues  = new HashMap<>();
        ticketValues.put("status", closedStatus); // This closedStatus Value needs to be get from the status mapping
        // of the Ticket Field response. You can refer to the getTicketClosedStatus()
        ZDPortalTicketsAPI.updateTicket(new ZDPortalCallback.TicketDetailsCallback() {
            @Override
            public void onTicketDetailsCallback(Ticket ticket) {
                //Ticket Status updated
            }

            @Override
            public void onException(ZDPortalException e) {
                //Ticket Status onexception
            }
        }, ticketId, ticketValues, null);
    }


    public void getTicketClosedStatus() {
        String departmentId = "";
        HashMap<String, String> params = new HashMap<>();
        params.put("departmentId", String.valueOf(departmentId)); //NO I18N
        ZDPortalTicketsAPI.getTicketFields(new ZDPortalCallback.TicketFieldsCallback() {
            @Override
            public void onTicketFieldsDownloaded(TicketFieldsList ticketFieldsList) {
                for(TicketField field :ticketFieldsList.getData()) {
                    if("status".equalsIgnoreCase(field.getApiName())) {
                        for(TicketStatusMapping mapping:field.getStatusMapping()) {
                            if("closed".equalsIgnoreCase(mapping.getName())) {
                                closedStatus = mapping.getMappingValue();
                                break;
                            }
                        }
                    }
                }
            }

            @Override
            public void onException(ZDPortalException e) {

            }
        }, params, "apiName"); //No I18N
    }
}
