/*
 * Janino - An embedded Java[TM] compiler
 *
 * Copyright (c) 2001-2010, Arno Unkrig
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the
 * following conditions are met:
 *
 *    1. Redistributions of source code must retain the above copyright notice, this list of conditions and the
 *       following disclaimer.
 *    2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the
 *       following disclaimer in the documentation and/or other materials provided with the distribution.
 *    3. The name of the author may not be used to endorse or promote products derived from this software without
 *       specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL
 * THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package comp;
import org.codehaus.commons.compiler.CompileException;
import org.codehaus.janino.Scanner;
import java.io.*;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.*;

import org.codehaus.janino.ByteArrayClassLoader;
import org.codehaus.janino.ClassLoaderIClassLoader;
import org.codehaus.janino.IClassLoader;
import org.codehaus.janino.Java;
import org.codehaus.janino.Parser;
import org.codehaus.janino.UnitCompiler;
import org.codehaus.janino.util.ClassFile;

/**
 * To set up a {@link SimpleCompiler} object, proceed as described for {@link ISimpleCompiler}.
 * Alternatively, a number of "convenience constructors" exist that execute the described steps
 * instantly.
 */
public class SimpleCompiler  {

    private ClassLoader parentClassLoader = Thread.currentThread().getContextClassLoader();

    private ClassLoader result = null;
    private IClassLoader iClassLoader = new ClassLoaderIClassLoader(this.parentClassLoader);
    

    public final void cook(Reader r) throws CompileException, IOException {
    	
        
		ClassFile[] classFiles = compileToClassFiles(r);
        
        //Mete los classFiles en el ClassLoader
        this.toClassLoader(classFiles);
    }
    
    public final ClassFile[] compileToClassFiles(Reader r) throws CompileException,
			IOException {
		
        Scanner scanner=new Scanner(null, r);
		
	// Parse the compilation unit.
        Java.CompilationUnit compilationUnit = new Parser(scanner).parseCompilationUnit();
        
        // Compile compilation unit to class files.
        ClassFile[] classFiles = new UnitCompiler(
            compilationUnit, this.iClassLoader            
        ).compileUnit(false, false, false);
	
        return classFiles;
    }
    

    public ClassLoader getClassLoader() {

    	if (this.result == null) throw new IllegalStateException("Must only be called after \"cook()\"");
        
    	return this.result;
    }

    private final ClassLoader toClassLoader(ClassFile[] classFiles) throws CompileException {

      // Convert the class files to bytes and store them in a Map.
      final Map classes = new HashMap(); // String className => byte[] data
      for (int i = 0; i < classFiles.length; ++i) {
          ClassFile cf = classFiles[i];
          classes.put(cf.getThisClassName(), cf.toByteArray());
      }

      // Create a ClassLoader that loads the generated classes.
      this.result = (ClassLoader) AccessController.doPrivileged(new PrivilegedAction() {
          public Object run() {
              return new ByteArrayClassLoader(
                  classes,                        // classes
                  SimpleCompiler.this.parentClassLoader // parent
              );
          }
      });
      return this.result;
  }
    
}
