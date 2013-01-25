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

package com.mediavision.util;

import android.content.Context;
import android.widget.Toast;

/** Generic helper class with utilities */
public class GenericUtils {
	
	private Context  mContext;

	/** Constructor */
	public GenericUtils(Context value) {
		mContext = value;
		
		/* TODO Would Android function call getApplicationContext() be better ? */
	}
	
	public Context getContext(){ return mContext; }
	
	/** Destructor */
	public void onDestroy(){
		mContext = null;
	}
	
	/** Some demo code, replace it with anything you want done when the user presses an item 
	 * @param <Callback>*/
    public <Callback> boolean ShowDemoClickAction(boolean LongClick, String SomeText, Callback SomeCallback){
    	/* TODO Change to case statement to handle more click types */
    	
        String WhatText = "";
    	if (LongClick) { WhatText = "Long"; }
    	
		final String message = "On"+ WhatText + "Click: " + SomeText;
        Toast.makeText(this.getContext(), message, Toast.LENGTH_SHORT).show();

        if (SomeCallback != null)
        	{ /* TODO Execute the callback function */ }
        
    return true;
    }
}
