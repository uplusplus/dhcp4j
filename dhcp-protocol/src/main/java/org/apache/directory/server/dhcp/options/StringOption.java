/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License. 
 *
 */
package org.apache.directory.server.dhcp.options;

import com.google.common.base.Charsets;

/**
 * The Dynamic Host Configuration Protocol (DHCP) provides a framework for
 * passing configuration information to hosts on a TCP/IP network. Configuration
 * parameters and other control information are carried in tagged data items
 * that are stored in the 'options' field of the DHCP message. The data items
 * themselves are also called "options." 
 * 
 * This abstract base class is for options
 * that carry a string.
 * 
 * @author <a href="mailto:dev@directory.apache.org">Apache Directory Project</a>
 */
public abstract class StringOption extends DhcpOption {

    private String string;


    /*
     * @see org.apache.directory.server.dhcp.options.DhcpOption#setData(byte[])
     */
    @Override
    public void setData(byte[] data) {
        string = new String(data, Charsets.ISO_8859_1);
    }


    /*
     * @see org.apache.directory.server.dhcp.options.DhcpOption#getData()
     */
    @Override
    public byte[] getData() {
        if (null == string) {
            return new byte[]{};
        }

        return string.getBytes(Charsets.ISO_8859_1);
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}