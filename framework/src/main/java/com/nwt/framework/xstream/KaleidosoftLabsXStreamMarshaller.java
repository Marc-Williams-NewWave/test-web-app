package com.nwt.framework.xstream;

import com.thoughtworks.xstream.io.HierarchicalStreamDriver;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import java.io.*;
import java.net.URL;

/**
 * Meant to remove the class attribute from the response
 *
 * @author: Prabakar Singaram
 * @created: 4/29/2013 11:51 AM
 * @company: NewWave Technologies Inc
 */
public class KaleidosoftLabsXStreamMarshaller implements HierarchicalStreamDriver {

     public HierarchicalStreamReader createReader(Reader reader) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }


     public HierarchicalStreamReader createReader(InputStream inputStream) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }


     public HierarchicalStreamReader createReader(URL url) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }


     public HierarchicalStreamReader createReader(File file) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }


     public HierarchicalStreamWriter createWriter(Writer writer) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }


     public HierarchicalStreamWriter createWriter(OutputStream outputStream) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
