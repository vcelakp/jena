/*****************************************************************************
 * Source code information
 * -----------------------
 * Original author    Ian Dickinson, HP Labs Bristol
 * Author email       Ian.Dickinson@hp.com
 * Package            Jena 2
 * Web                http://sourceforge.net/projects/jena/
 * Created            10 Feb 2003
 * Filename           $RCSfile: Ontology.java,v $
 * Revision           $Revision: 1.2 $
 * Release status     $State: Exp $
 *
 * Last modified on   $Date: 2003-03-27 16:28:14 $
 *               by   $Author: ian_dickinson $
 *
 * (c) Copyright 2002-2003, Hewlett-Packard Company, all rights reserved. 
 * (see footer for full conditions)
 * ****************************************************************************/

// Package
///////////////
package com.hp.hpl.jena.ontology;



// Imports
///////////////
import com.hp.hpl.jena.ontology.path.PathSet;


/**
 * <p>
 * Interface encapsulating the distinguished instance in a given ontology
 * document that presents meta-data and other processing data about the document
 * (including which other documents are imported by a document).
 * </p>
 *
 * @author Ian Dickinson, HP Labs
 *         (<a  href="mailto:Ian.Dickinson@hp.com" >email</a>)
 * @version CVS $Id: Ontology.java,v 1.2 2003-03-27 16:28:14 ian_dickinson Exp $
 */
public interface Ontology
    extends OntResource
{
    // Constants
    //////////////////////////////////



    // External signature methods
    //////////////////////////////////

    /**
     * <p>
     * Answer an {@link PathSet accessor} for the 
     * <code>imports</code>
     * property of an ontology. The accessor
     * can be used to perform a variety of operations, including getting and setting the value.
     * </p>
     * 
     * @return An abstract accessor for the imports of an ontology element
     */
    public PathSet p_imports();
    

    /**
     * <p>
     * Answer an {@link PathSet accessor} for the 
     * <code>backwardCompatibleWith</code>
     * property of an ontology. The accessor
     * can be used to perform a variety of operations, including getting and setting the value.
     * </p>
     * 
     * @return An abstract accessor for the imports of an ontology element
     * @exception {@link OntologyException} if language profile for the ontology model that this
     * resource is attached to does not support this property.
     */
    public PathSet p_backwardCompatibleWith();
    

    /**
     * <p>
     * Answer an {@link PathSet accessor} for the 
     * <code>priorVersion</code>
     * property of an ontology. The accessor
     * can be used to perform a variety of operations, including getting and setting the value.
     * </p>
     * 
     * @return An abstract accessor for the imports of an ontology element
     * @exception {@link OntologyException} if language profile for the ontology model that this
     * resource is attached to does not support this property.
     */
    public PathSet p_priorVersion();
    

    /**
     * <p>
     * Answer an {@link PathSet accessor} for the 
     * <code>incompatibleWith</code>
     * property of an ontology. The accessor
     * can be used to perform a variety of operations, including getting and setting the value.
     * </p>
     * 
     * @return An abstract accessor for the imports of an ontology element
     * @exception {@link OntologyException} if language profile for the ontology model that this
     * resource is attached to does not support this property.
     */
    public PathSet p_incompatibleWith();
    

    /**
     * <p>
     * Answer an {@link PathSet accessor} for the 
     * <code>versionInfo</code>
     * property of an ontology. The accessor
     * can be used to perform a variety of operations, including getting and setting the value.
     * </p>
     * 
     * @return An abstract accessor for the imports of an ontology element
     * @exception {@link OntologyException} if language profile for the ontology model that this
     * resource is attached to does not support this property.
     */
    public PathSet p_versionInfo();
}


/*
    (c) Copyright Hewlett-Packard Company 2002-2003
    All rights reserved.

    Redistribution and use in source and binary forms, with or without
    modification, are permitted provided that the following conditions
    are met:

    1. Redistributions of source code must retain the above copyright
       notice, this list of conditions and the following disclaimer.

    2. Redistributions in binary form must reproduce the above copyright
       notice, this list of conditions and the following disclaimer in the
       documentation and/or other materials provided with the distribution.

    3. The name of the author may not be used to endorse or promote products
       derived from this software without specific prior written permission.

    THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
    IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
    OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
    IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
    INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
    NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
    DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
    THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
    (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
    THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
