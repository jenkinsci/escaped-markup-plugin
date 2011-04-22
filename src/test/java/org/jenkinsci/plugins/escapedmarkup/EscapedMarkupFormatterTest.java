/*
 * The MIT License
 *
 * Copyright 2011 Seiji Sogabe
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package org.jenkinsci.plugins.escapedmarkup;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test
 * 
 * @author Seiji Sogabe
 */
public class EscapedMarkupFormatterTest {

    private EscapedMarkupFormatter instance;
    
    public EscapedMarkupFormatterTest() {
    }

    @Before
    public void setUp() {
        instance = new EscapedMarkupFormatter();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of translate method, of class EscapedMarkupFormatter.
     */
    @Test
    public void testTranslate() throws Exception {
        assertEquals("&lt;script>alert(&#039;XSS&#039;)&lt;/script>", instance.translate("<script>alert('XSS')</script>"));
        assertEquals("&lt;a href=&quot;alert(&#039;XSS&#039;)&lt;/script>&quot;>XSS&lt;/a>", 
                instance.translate("<a href=\"alert('XSS')</script>\">XSS</a>"));
    }
}
