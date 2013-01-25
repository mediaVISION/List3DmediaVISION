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

package com.mediavision.app;

import com.mediavision.dynamics.DynamicListView;
import com.mediavision.util.GenericUtils;
import com.mediavision.util.WindowUtils;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
//import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;

public abstract class MVDynamicListActivity extends Activity {

	/* ALL private to protect them from outside manipulation */
	private boolean			mDebug;									/* Used for future purposes */
    private GenericUtils 	mGenericUtils;
    private WindowUtils 	mWindowUtils;
	private DynamicListView mDynamicListView;
	private Menu 			mDynamicListMenu;
	
	/* TODO Extend list of member variables as required */
    
    public void onCreate(final Bundle savedInstanceState, int layoutResID) {
        super.onCreate(savedInstanceState);

        InitializeMembers(layoutResID);
        setContentView(layoutResID);

        onAfterCreate();
    }

    @Override
    public void onCreate(final Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);

    	InitializeMembers(0);
        onAfterCreate();
    }
    
    @Override 
    public void setContentView(int layoutResID){
    	super.setContentView(layoutResID);
    }
    
    public abstract void onAfterCreate();
    
    private void InitializeMembers(int layoutResID) {
        setDebug(false);								/* Use the SET function as the function may be extended */
        setGenericUtils(new GenericUtils(this));
        setWindowUtils(new WindowUtils(this));
    }
    
    public abstract void onBeforeDestroy();
    
    @Override
    public void onDestroy() {
    	onBeforeDestroy();								/* Execute user defined destructor */
    	DestroyMembers();								/* Clear class members */

    	super.onDestroy();
    }

    private void DestroyMembers() {
    	getWindowUtils().onDestroy();						/* Clear references to external Utils */
    	setWindowUtils(null);							
    	getGenericUtils().onDestroy();
        setGenericUtils(null);
    }
    
	public boolean			getDebug()									{ return mDebug; }
	public GenericUtils		getGenericUtils()							{ return mGenericUtils; }
	public WindowUtils		getWindowUtils() 							{ return mWindowUtils; }
	public DynamicListView	getDynamicListView()						{ return mDynamicListView; }
	public Menu				getDynamicListMenu()						{ return mDynamicListMenu; }

	public void				setDebug(boolean value)						{ mDebug			= value; }
	public void				setGenericUtils(GenericUtils value)			{ mGenericUtils		= value; }
	public void				setWindowUtils(WindowUtils value) 			{ mWindowUtils		= value; }
	public void				setDynamicListView(DynamicListView value)	{ mDynamicListView	= value; }
	public void				setDynamicListMenu(Menu value)				{ mDynamicListMenu	= value; }

	@Override
    public boolean onCreateOptionsMenu(final Menu menu) {
    	return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
    	return super.onOptionsItemSelected(item);
    }
    
    public OnItemClickListener getListItemClickListener(){

    	return new OnItemClickListener() {
    		
           	public void onItemClick( final AdapterView<?> parent,
           							 final View view,
           							 final int position,
           							 final long id) {
            	
           	}
        };
    }

    public OnItemLongClickListener getListItemLongClickListener(){

    	return new OnItemLongClickListener() {
			
            public boolean onItemLongClick( final AdapterView<?> parent,
            								final View view,
            								final int position,
            								final long id) {
            	return true;
            }
        };
	}
}