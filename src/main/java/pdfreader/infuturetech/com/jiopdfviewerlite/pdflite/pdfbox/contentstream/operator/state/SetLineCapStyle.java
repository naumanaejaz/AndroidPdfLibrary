/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package pdfreader.infuturetech.com.jiopdfviewerlite.pdflite.pdfbox.contentstream.operator.state;

import android.graphics.Paint;

import pdfreader.infuturetech.com.jiopdfviewerlite.pdflite.pdfbox.contentstream.operator.MissingOperandException;
import pdfreader.infuturetech.com.jiopdfviewerlite.pdflite.pdfbox.contentstream.operator.Operator;
import pdfreader.infuturetech.com.jiopdfviewerlite.pdflite.pdfbox.contentstream.operator.OperatorProcessor;
import pdfreader.infuturetech.com.jiopdfviewerlite.pdflite.pdfbox.cos.COSBase;
import pdfreader.infuturetech.com.jiopdfviewerlite.pdflite.pdfbox.cos.COSNumber;

import java.io.IOException;
import java.util.List;

/**
 * J: Set the line cap style.
 *
 */
public class SetLineCapStyle extends OperatorProcessor
{
    @Override
    public void process(Operator operator, List<COSBase> arguments) throws IOException
    {
        if (arguments.size() < 1)
        {
            throw new MissingOperandException(operator, arguments);
        }
        Paint.Cap lineCapStyle;
        switch(((COSNumber)arguments.get( 0 )).intValue())  {
            case 0:
                lineCapStyle = Paint.Cap.BUTT;
                break;
            case 1:
                lineCapStyle = Paint.Cap.ROUND;
                break;
            case 2:
                lineCapStyle = Paint.Cap.SQUARE;
                break;
            default:
                lineCapStyle = null;
        }
        context.getGraphicsState().setLineCap( lineCapStyle );
    }

    @Override
    public String getName()
    {
        return "J";
    }
}
