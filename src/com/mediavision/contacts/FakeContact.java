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

import android.graphics.drawable.Drawable;

public class FakeContact {
    private String   mName;								/* Name of the contact */
    private String   mNumber;							/* Phone number of the contact */
    private Drawable mPhoto;							/* Photo of the contact, can be any kind of drawable */
    
    /* Constructor */
    public FakeContact(final String name, final String number, final Drawable photo) {
        mName   = name;
        mNumber = number;
        mPhoto 	= photo;
    }

    /* GET functions */
    public String   getName()	{ return mName;   }		/* No need to split over various lines, just short and readable */
    public String   getNumber() { return mNumber; }
    public Drawable getPhoto()	{ return mPhoto;  }

    /* SET functions */
    public String   setName(String name)	 { mName   = name;   return mName;   }	
    public String   setNumber(String number) { mNumber = number; return mNumber; }
    public Drawable setPhoto(Drawable photo) { mPhoto  = photo;  return mPhoto;  }

    /* Set all at once, UPDATE function */
    public FakeContact updateContact(final String name, final String number, final Drawable photo) {
        mName   = name;
        mNumber = number;
        mPhoto 	= photo;
    return this;
    }
}

/*
 * COMMENT
 * 
 *  Familiarize yourself with GET/SET/UPDATE constructions and using functions to access class members,
 *  no matter how little those functions become. It is not only consistent, but it protects the variables
 *  as well and your code will be much easier to modify/maintain when the specifications for a class
 *  member change. 
 * 
 */

/*
 * GENERAL COMMENT on the "FakeContact" class 
 *	
 *	Be aware that we are aiming to get recycable code and that this class is not 100% recycable. 
 *	A "drawable" is an Android type and if we were to incorporate it in a generic Java library, the
 *	entire Android handling of "drawable" types will still need to be used somewhere down the line.
 *	This means that we need to implement a more generic form of Java graphics.
 *
 *	For simplicity sake it is left "As-Is" and will be dealt with by the time we are really going
 *	to do useful things with contacts...
 */

/*
 * SOME EXTRA INFO
 * 
 *  In Object Pascal you now would "publish" 3 so called "property" definitions using the GET/SET
 *  functions below to give programmers access to the above hidden private variables, like this:
 * 
 *  Published
 * 		Property Name   : String   Read getName()   Write   setName(name  : String);
 * 		Property Number : String   Read getNumber() Write setNumber(number: String);
 * 		Property Photo  : Drawable Read getName()   Write  setPhoto(photo : Drawable);
 * 
 *  Usage would be:
 *
 * 			SomeContact.Name := "Johnny Layman III";
 *
 *  Somewhat more elegant, but basically the same as using the function call in Java:
 * 
 *			SomeContact.setName("Johnny Layman III");
 * 
 * In both cases the content of "mName" will be "Johnny Layman III".
 * 
 *  									(So far a little insight in another programming language).
 */