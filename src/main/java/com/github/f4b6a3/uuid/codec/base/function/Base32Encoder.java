/*
 * MIT License
 * 
 * Copyright (c) 2018-2022 Fabio Lima
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.f4b6a3.uuid.codec.base.function;

import java.util.UUID;

import com.github.f4b6a3.uuid.codec.base.BaseN;

/**
 * Function that encodes a UUID to a base-32 string.
 * <p>
 * It encodes in lower case only.
 * 
 * @see <a href="https://www.rfc-editor.org/rfc/rfc4648">RFC-4648</a>
 */
public final class Base32Encoder extends BaseNEncoder {

	private static final int CHAR_LENGTH = 26;

	public Base32Encoder(BaseN base) {
		super(base);
	}

	@Override
	public String apply(UUID uuid) {

		final char[] chars = new char[CHAR_LENGTH];
		long msb = uuid.getMostSignificantBits();
		long lsb = uuid.getLeastSignificantBits();

		chars[0x00] = alphabet.get((int) ((msb >>> 59) & 0b11111));
		chars[0x01] = alphabet.get((int) ((msb >>> 54) & 0b11111));
		chars[0x02] = alphabet.get((int) ((msb >>> 49) & 0b11111));
		chars[0x03] = alphabet.get((int) ((msb >>> 44) & 0b11111));
		chars[0x04] = alphabet.get((int) ((msb >>> 39) & 0b11111));
		chars[0x05] = alphabet.get((int) ((msb >>> 34) & 0b11111));
		chars[0x06] = alphabet.get((int) ((msb >>> 29) & 0b11111));
		chars[0x07] = alphabet.get((int) ((msb >>> 24) & 0b11111));
		chars[0x08] = alphabet.get((int) ((msb >>> 19) & 0b11111));
		chars[0x09] = alphabet.get((int) ((msb >>> 14) & 0b11111));
		chars[0x0a] = alphabet.get((int) ((msb >>> 9) & 0b11111));
		chars[0x0b] = alphabet.get((int) ((msb >>> 4) & 0b11111));

		chars[0x0c] = alphabet.get((int) ((msb << 1) & 0b11111) | (int) ((lsb >>> 63) & 0b11111));

		chars[0x0d] = alphabet.get((int) ((lsb >>> 58) & 0b11111));
		chars[0x0e] = alphabet.get((int) ((lsb >>> 53) & 0b11111));
		chars[0x0f] = alphabet.get((int) ((lsb >>> 48) & 0b11111));
		chars[0x10] = alphabet.get((int) ((lsb >>> 43) & 0b11111));
		chars[0x11] = alphabet.get((int) ((lsb >>> 38) & 0b11111));
		chars[0x12] = alphabet.get((int) ((lsb >>> 33) & 0b11111));
		chars[0x13] = alphabet.get((int) ((lsb >>> 28) & 0b11111));
		chars[0x14] = alphabet.get((int) ((lsb >>> 23) & 0b11111));
		chars[0x15] = alphabet.get((int) ((lsb >>> 18) & 0b11111));
		chars[0x16] = alphabet.get((int) ((lsb >>> 13) & 0b11111));
		chars[0x17] = alphabet.get((int) ((lsb >>> 8) & 0b11111));
		chars[0x18] = alphabet.get((int) ((lsb >>> 3) & 0b11111));
		chars[0x19] = alphabet.get((int) ((lsb << 2) & 0b11111));

		return new String(chars);
	}

}
