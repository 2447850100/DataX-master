package com.alibaba.datax.core.transport.transformer;

import com.alibaba.datax.common.element.Column;
import com.alibaba.datax.common.element.Record;
import com.alibaba.datax.common.element.StringColumn;
import com.alibaba.datax.transformer.Transformer;

public class MyTransformer extends Transformer {

    public MyTransformer() {
        setTransformerName("dx_transformer");
    }

    @Override
    public Record evaluate(Record record, Object... paras) {
        int columnIndex;
        columnIndex = (Integer) paras[0];
        Column column = record.getColumn(columnIndex);
        String s = column.asString();
        System.out.println("获取到s" + s);
        s = s.toLowerCase();
        record.setColumn(columnIndex, new StringColumn(s));
        return record;
    }
}
