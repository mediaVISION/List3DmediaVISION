/*
 * Copyright (c) 2010, Sony Ericsson Mobile Communication AB. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, 
 * are permitted provided that the following conditions are met:
 *
 *    * Redistributions of source code must retain the above copyright notice, this 
 *      list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above copyright notice,
 *      this list of conditions and the following disclaimer in the documentation
 *      and/or other materials provided with the distribution.
 *    * Neither the name of the Sony Ericsson Mobile Communication AB nor the names
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

package com.mediavision.dynamics;

/**
 * A very simple dynamics implementation with spring-like behavior
 */
public class SimpleDynamics extends Dynamics {

    /** The friction factor */
    private float mFrictionFactor;

    /** The snap to factor */
    private float mSnapToFactor;

    /**
     * Creates a SimpleDynamics object
     * 
     * @param frictionFactor The friction factor. Should be between 0 and 1.
     *            A higher number means a slower dissipating speed.
     * @param snapToFactor The snap to factor. Should be between 0 and 1. A
     *            higher number means a stronger snap.
     */
    public SimpleDynamics(final float frictionFactor, final float snapToFactor) {
        mFrictionFactor = frictionFactor;
        mSnapToFactor = snapToFactor;
    }

    @Override
    protected void onUpdate(final int dt) {
        // update the velocity based on how far we are from the snap point
        mVelocity += getDistanceToLimit() * mSnapToFactor;

        // then update the position based on the current velocity
        mPosition += mVelocity * dt / 1000;

        // and finally, apply some friction to slow it down
        mVelocity *= mFrictionFactor;
    }
}
