package com.ticketfield.ticket_field_configuration_sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.zoho.deskportalsdk.android.model.PreFillTicketFiled;
import com.zoho.deskportalsdk.android.network.DeskCallback;
import com.zoho.deskportalsdk.android.network.DeskTicketFieldList;
import com.zoho.deskportalsdk.android.network.DeskTicketFieldResponse;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> listTobeShown = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getTicketFields();
    }

    private void getTicketFields() {
        MyApplication.zohoDeskPortalSDKInstnace.getTicketsFieldsList(fieldsCallback);
        /*If the ASAP is configured for single department, department id is opitonal. Else, the department id is mandatory*/
        MyApplication.zohoDeskPortalSDKInstnace.getTicketsFieldsList(fieldsCallback, 0l);
    }

    public void  configureListToBeShown(View view) {

        listTobeShown.add("field api name"); /* replace your field api name*/
        listTobeShown.add("field api name"); /* replace your field api name. Field API name can be found through, ticket fields API.*/
        MyApplication.zohoDeskPortalSDKInstnace.setTicketsFieldsListTobeShown(listTobeShown);
        /*If the ASAP is configured for single department, department id is opitonal. Else, the department id is mandatory*/
        MyApplication.zohoDeskPortalSDKInstnace.setTicketsFieldsListTobeShown(listTobeShown, 0l);
    }

    public void configureValuesToFields(View view) {
        List<PreFillTicketFiled> preFillTicketFiledList = new ArrayList<>();
        Object fieldValue = "ticket field value";
        boolean iseditable = true;
        preFillTicketFiledList.add(new PreFillTicketFiled("field api name", fieldValue, iseditable));
        preFillTicketFiledList.add(new PreFillTicketFiled("field api name", fieldValue, iseditable));
        MyApplication.zohoDeskPortalSDKInstnace.preFillTicketFields(preFillTicketFiledList);
        /*If the ASAP is configured for single department, department id is opitonal. Else, the department id is mandatory*/
        MyApplication.zohoDeskPortalSDKInstnace.preFillTicketFields(preFillTicketFiledList, 0l);

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
        MyApplication.zohoDeskPortalSDKInstnace.startNewTicket(this);
    }

    private DeskCallback.DeskTicketsFieldsCallback fieldsCallback = new DeskCallback.DeskTicketsFieldsCallback() {
        @Override
        public void onTicketsFieldsLoaded(DeskTicketFieldList deskTicketFieldList) {
            for(DeskTicketFieldResponse fieldResponse:deskTicketFieldList.getData()) {
                listTobeShown.add(fieldResponse.getApiName());
                //populate the list listTobeShown for the field that needs to be shown in the Submit Ticket module
            }

        }

        @Override
        public void onException(DeskCallback.DeskException e) {

        }
    };
}
