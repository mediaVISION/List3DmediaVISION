/**
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

package com.mediavision.contacts;

import com.mediavision.list3d.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FakeContactListRow extends ArrayAdapter<FakeContact> {

	private int mlayoutResID;

    public FakeContactListRow(Context context, ArrayList<FakeContact> ContactList, int LayoutResID) {
        super(context, 0, ContactList);
 
        setLayoutResID(LayoutResID);
        
        /* Add your own, extra initialization code */
    }
    
    /* GET functions */
	public int	getLayoutResID()			{ return mlayoutResID; }

    /* SET functions */
	private void setLayoutResID(int value)	{ mlayoutResID = value; }

	@Override
    public View getView(int position, View convertView, ViewGroup parent) {
        
		View ContactView = convertView;
        
		if (ContactView == null) {
			ContactView = LayoutInflater.from(getContext()).inflate(getLayoutResID(), null);}

        final TextView  Name   =  (TextView)ContactView.findViewById(R.id.contact_name);
        final TextView  Number =  (TextView)ContactView.findViewById(R.id.contact_number);
        final ImageView Photo  = (ImageView)ContactView.findViewById(R.id.contact_photo);

          Name.setText(getItem(position).getName());
        Number.setText(getItem(position).getNumber());
         Photo.setImageDrawable(getItem(position).getPhoto());

        /* DEMO: show off some long text at contact 15. Remove/Comment Out if not required */
        if (position == 14) { Name.setText(R.string.long_text); }

        return ContactView;
    }
	public void ShowDemoClickAction() {
	}
	public boolean ShowDemoLongClickAction() {
		return true;
	}
}