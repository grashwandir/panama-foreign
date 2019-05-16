/*
 * Copyright (c) 2019, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package java.lang.invoke;

import static java.lang.invoke.MethodHandleStatics.UNSAFE;

/**
 * Base class for memory address var handle implementations.
 */
abstract class VarHandleMemoryAddressBase extends VarHandle {
    final boolean be;
    final long length;
    final long offset;
    final long alignment;

    VarHandleMemoryAddressBase(VarForm form, boolean be, long length, long offset, long alignment) {
        super(form);
        this.be = be;
        this.length = length;
        this.offset = offset;
        this.alignment = alignment;
    }

    static IllegalStateException newIllegalStateExceptionForMisalignedAccess(long address) {
        return new IllegalStateException("Misaligned access at address: " + address);
    }
}
