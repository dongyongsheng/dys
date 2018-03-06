//License
/***
 * Java Modbus Library (jamod)
 * Copyright (c) 2002-2004, jamod development team
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * Neither the name of the author nor the names of its contributors
 * may be used to endorse or promote products derived from this software
 * without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDER AND CONTRIBUTORS ``AS
 * IS'' AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE REGENTS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 ***/
package util;

/**
 * Interface defining all constants related to the Modbus protocol.
 * 
 * @author Dieter Wimberger
 * @version 1.2rc1 (09/11/2004)
 */
public interface ControlParams {

	/**
	 * JVM flag for debug mode. Can be set passing the system property
	 * net.wimpi.modbus.debug=false|true (-D flag to the jvm).
	 */
	// public static final boolean debug =
	// "true".equals(System.getProperty("net.wimpi.modbus.debug"));
	/**
	 * Defines the maximum number of bits in multiple read/write of input
	 * discretes or coils (<b>2000</b>).
	 */
	public static final int		MAX_BITS					= 2000;

	/**
	 * Defines the Modbus slave exception offset that is added to the function
	 * code, to flag an exception.
	 */
	public static final int		EXCEPTION_OFFSET			= 128;						// the
	// last
	// valid
	// function
	// code
	// is
	// 127

	/**
	 * Defines the Modbus slave exception type <tt>illegal function</tt>.
	 * This exception code is returned if the slave:
	 * <ul>
	 * <li>does not implement the function code <b>or</b></li>
	 * <li>is not in a state that allows it to process the function</li>
	 * </ul>
	 */
	public static final int		ILLEGAL_FUNCTION_EXCEPTION	= 1;

	/**
	 * Defines the Modbus slave exception type <tt>illegal data address</tt>.
	 * This exception code is returned if the reference:
	 * <ul>
	 * <li>does not exist on the slave <b>or</b></li>
	 * <li>the combination of reference and length exceeds the bounds of the
	 * existing registers. </li>
	 * </ul>
	 */
	public static final int		ILLEGAL_ADDRESS_EXCEPTION	= 2;

	/**
	 * Defines the Modbus slave exception type <tt>illegal data value</tt>.
	 * This exception code indicates a fault in the structure of the data values
	 * of a complex request, such as an incorrect implied length.<br>
	 * <b>This code does not indicate a problem with application specific
	 * validity of the value.</b>
	 */
	public static final int		ILLEGAL_VALUE_EXCEPTION		= 3;

	/**
	 * Defines the default port number of Modbus (=<tt>502</tt>).
	 */
	public static final int		DEFAULT_PORT				= 502;

	/**
	 * Defines the maximum message length in bytes (=<tt>256</tt>).
	 */
	// public static final int MAX_MESSAGE_LENGTH = 256;
	/**
	 * Defines the default transaction identifier (=<tt>0</tt>).
	 */
	public static final int		DEFAULT_TRANSACTION_ID		= 0;

	/**
	 * Defines the default protocol identifier (=<tt>0</tt>).
	 */
	public static final int		DEFAULT_PROTOCOL_ID			= 0;

	/**
	 * Defines the default unit identifier (=<tt>0</tt>).
	 */
	public static final int		DEFAULT_UNIT_ID				= 0;

	/**
	 * Defines the default setting for validity checking in transactions (=<tt>true</tt>).
	 */
	public static final boolean	DEFAULT_VALIDITYCHECK		= true;

	/**
	 * Defines the default setting for I/O operation timeouts in milliseconds (=<tt>3000</tt>).
	 */
	public static final int		DEFAULT_TIMEOUT				= 3000;

	/**
	 * Defines the default reconnecting setting for transactions (=<tt>false</tt>).
	 */
	public static final boolean	DEFAULT_RECONNECTING		= false;

	/**
	 * Defines the default amount of retires for opening a connection (=<tt>3</tt>).
	 */
	public static final int		DEFAULT_RETRIES				= 3;

	/**
	 * Defines the default number of msec to delay before transmission (=<tt>50</tt>).
	 */
	public static final int		DEFAULT_TRANSMIT_DELAY		= 0;

	/**
	 * Defines the maximum value of the transaction identifier.
	 */
	public static final int		MAX_TRANSACTION_ID			= (Short.MAX_VALUE * 2);

	/**
	 * Defines the serial encoding "ASCII".
	 */
	public static final String	SERIAL_ENCODING_ASCII		= "ascii";
	/**
	 * Defines the serial encoding "RTU".
	 */
	public static final String	SERIAL_ENCODING_RTU			= "rtu";
	/**
	 * Defines the serial encoding "BIN".
	 */
	public static final String	SERIAL_ENCODING_BIN			= "bin";
	/**
	 * Defines the default serial encoding (ASCII).
	 */
	public static final String	DEFAULT_SERIAL_ENCODING		= SERIAL_ENCODING_ASCII;
	public static final String	MODBUS_RTU					= "Modbus-RTU";
	public static final String	MODBUS_ASCII				= "Modbus-ASCII";
	public static final String	MODBUS_BIN					= "Modbus-BIN";
	public static final String	DLT645						= "DLT645";
	public static final String	ASCII						= "ASCII";
	public static final String	DEFAULT_PROTOCOL_TYPE		= MODBUS_RTU;

	public static final int		DLT645_READ_DATA			= 1;
	public static final int		DLT645_READ_LATEDATA		= 2;
	public static final int		DLT645_REREAD_DATA			= 3;
	public static final int		DLT645_WRITE_DATA			= 4;
	public static final int		DLT645_WRITE_UNITADDR		= 10;

	public static final int		ASCII_CONFIG_COMM			= 1;

	/**
	 * Flag to adjust the debug output level at compile time.
	 * <P>
	 * The debug levels are as follows:
	 * <UL>
	 * <LI> 0 - No debug output, systems runs silently
	 * <LI> 1 - Very basic debug information. Startup information and signals
	 * that a request or response cycle is starting
	 * <LI> 2 - Basic debug output. Basic send, receieve and processing messages
	 * from both messaging and transport levels.
	 * <LI> 3 - Detailed output of all operations but falling short of packet
	 * dumps.
	 * <LI> 4 - Verbose output. This includes full packet dumps at both
	 * messaging level and transport level.
	 * </UL>
	 */
	public static final int		debug						= 5;

	/**
	 * Command code to read multiple registers.
	 */
	public static final byte	READ_MULTIPLE_REGISTERS		= (byte) 0x03;

	/**
	 * Command code to read imput registers.
	 */
	public static final byte	READ_INPUT_REGISTERS		= (byte) 0x04;

	/**
	 * Command code to write multiple registers.
	 */
	public static final byte	WRITE_MULTIPLE_REGISTERS	= (byte) 0x10;

	/**
	 * Command code to write a single register.
	 */
	public static final byte	WRITE_SINGLE_REGISTER		= (byte) 0x06;

	/**
	 * Command code to read multiple coils.
	 */
	public static final byte	READ_COILS					= (byte) 0x01;

	/**
	 * Command code to write a single coil.
	 */
	public static final byte	WRITE_COIL					= (byte) 0x01;

	/**
	 * Command code to read read input discretes.
	 */
	public static final byte	READ_INPUT_DISCRETES		= (byte) 0x02;

	/**
	 * Command code to turn a single coil off.
	 */
	public static final byte	COIL_OFF					= (byte) 0x00;

	/**
	 * Command code to turn a single coil on.
	 */
	public static final byte	COIL_ON						= (byte) 0xFF;

	/**
	 * Command code to read the exception status.
	 */
	public static final byte	READ_EXCEPTION_STATUS		= (byte) 0x07;

	/**
	 * Function code modfifer for exceptions. This value is added to the
	 * function code to signify that some sort of error has occured in the
	 * function
	 */
	public static final byte	EXCEPTION_MODIFIER			= (byte) 0x80;

	/**
	 * Exception code to signify that the function code is unknown or illegal.
	 */
	public static final byte	ILLEGAL_FUNCTION			= (byte) 0x01;

	/**
	 * Exception code to signify that the request contains an illegal data
	 * address.
	 */
	public static final byte	ILLEGAL_DATA_ADDRESS		= (byte) 0x02;

	/**
	 * Exception code to signify that the request contains an illegal data
	 * value.
	 */
	public static final byte	ILLEGAL_DATA_VALUE			= (byte) 0x03;

	/**
	 * Exception code to signify that the request whould have generated an
	 * illegaly long response.
	 */
	public static final byte	ILLEGAL_RESPONSE_LENGTH		= (byte) 0x04;

	/**
	 * Highest permissible address value. This corresponds to a full scale 16
	 * bit unsigned integer.
	 */
	public static final int		ADDRESS_MAX					= 65535;

	/**
	 * Longest legal message length.
	 */
	public static final int		MAX_MESSAGE_LENGTH			= 256;

}// class Modbus

