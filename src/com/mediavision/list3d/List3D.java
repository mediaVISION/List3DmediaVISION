/*
 * Copyright (C) 2012 rene van der lende MEDIAVISION(tm)
 *
 * Redistribution and use in source and binary forms, with or without modification, 
 * are permitted provided that the following conditions are met:
 *
 *    * Redistributions of source code must retain this copyright notice, this 
 *      list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce this copyright notice,
 *      this list of conditions and the following disclaimer in the documentation
 *      and/or other materials provided with the distribution.
 *    * Neither the name of rene van der lende MEDIAVISION(tm) nor the names
 *      of its contributors may be used to endorse or promote products derived from
 *      this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.mediavision.list3d;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
//import android.widget.AdapterView.OnItemLongClickListener;

import com.mediavision.app.MVDynamicListActivity;
import com.mediavision.dynamics.DynamicListView;
import com.mediavision.contacts.FakeContactArrayList;

/**
 * Main program to test a dynamic list of 3D items with fake contact information
 */
public class List3D extends MVDynamicListActivity {

    private FakeContactArrayList mContactList1,
    							 mContactList2,
    							 mContactList3;
    
    public String mContactName;
    
    @Override
    public void onCreate(final Bundle savedInstanceState) {

    	/* TODO Let super do generic class member initialization, no need to use onCreate, use onAfterCreate instead */
    	super.onCreate(savedInstanceState, R.layout.main);
        
        /* ContentView will be set in super */
    }

    @Override
    public void onAfterCreate(){
        mContactList1 = new FakeContactArrayList( this, R.layout.fake_contacts_1,
        						(DynamicListView)findViewById(R.id.contact_list_1));		 /* Uses defaults */
        
        mContactList2 = new FakeContactArrayList( this, R.layout.fake_contacts_2,
        						(DynamicListView)findViewById(R.id.contact_list_2),
        						getResources().getDrawable(R.drawable.mg_self), 21);

        mContactList3 = new FakeContactArrayList( this, R.layout.fake_contacts_3,
								(DynamicListView)findViewById(R.id.contact_list_3), 41, 20);

		mContactList1.getContactListView().setOnItemClickListener(getListItemClickListener());
		mContactList2.getContactListView().setOnItemClickListener(getListItemClickListener());
		mContactList3.getContactListView().setOnItemClickListener(getListItemClickListener());

		/* TODO Long Click doesn't get triggered, maybe wait too long??? */
//		mContactList1.getContactListView().setOnItemLongClickListener(getListItemLongClickListener());
//		mContactList2.getContactListView().setOnItemLongClickListener(getListItemLongClickListener());
//		mContactList3.getContactListView().setOnItemLongClickListener(getListItemLongClickListener());
    }

    @Override
	public void onBeforeDestroy() {
    	/* TODO clear local members */
	}
   
    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
    	
    	/* TODO Move menu to super, menuResID as parameter */

    	getMenuInflater().inflate(R.menu.list3d_menu, menu);							/* Main menu from resources */
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
    	
        switch (item.getItemId()) {
       	case R.id.opt_rotation:
       		mContactList1.getContactListView().enableRotation(!mContactList1.getContactListView().isRotationEnabled());
       		mContactList2.getContactListView().enableRotation(!mContactList2.getContactListView().isRotationEnabled());
       		mContactList3.getContactListView().enableRotation(!mContactList2.getContactListView().isRotationEnabled());
            return true;

       	case R.id.opt_lightning:
       		mContactList1.getContactListView().enableLight(!mContactList1.getContactListView().isLightEnabled());
       		mContactList2.getContactListView().enableLight(!mContactList2.getContactListView().isLightEnabled());
       		mContactList3.getContactListView().enableLight(!mContactList3.getContactListView().isLightEnabled());
            return true;

       	case R.id.opt_dynamics:
       		mContactList1.getContactListView().enableDynamics(!mContactList1.getContactListView().isDynamicsEnabled());
       		mContactList2.getContactListView().enableDynamics(!mContactList2.getContactListView().isDynamicsEnabled());
       		mContactList3.getContactListView().enableDynamics(!mContactList3.getContactListView().isDynamicsEnabled());
            return true;

        default:
            return false;
        }
    }
    
    public OnItemClickListener getListItemClickListener(){
    	return new OnItemClickListener() {
    		
           	public void onItemClick( final AdapterView<?> parent,
           							 final View view,
           							 final int position,
           							 final long id) {
            
           	/* Notice the difference between Click and LongClick Listener, only LongClickListener has a return value */
           	getGenericUtils().ShowDemoClickAction(false, getContactName(parent, position), null);
           	}
        };
    }
/*
    public OnItemLongClickListener getListItemLongClickListener(){

    	return new OnItemLongClickListener() {
			
            public boolean onItemLongClick( final AdapterView<?> parent, 
            								final View view,
            								final int position,
            								final long id) {

 //         Notice the difference between Click and LongClick Listener, only LongClickListener has a return value
           	return getGenericUtils().ShowDemoClickAction(false, getContactName(parent, position), null);
            }
        };
	}
*/
    private String getContactName(final AdapterView<?> parent, final int position) {
       	if        (parent.getId() == mContactList1.getListViewID()) { return mContactList1.get(position).getName(); }
       	else { if (parent.getId() == mContactList2.getListViewID()) { return mContactList2.get(position).getName(); }
   		else														{ return mContactList3.get(position).getName(); }
       	}
    }
    
}