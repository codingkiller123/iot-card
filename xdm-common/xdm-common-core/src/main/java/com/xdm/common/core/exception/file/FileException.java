package com.xdm.common.core.exception.file;

import com.xdm.common.core.exception.BaseException;

/**
 * 文件信息异常类
 *
 * @author xdm
 */
public class FileException extends BaseException {
    private static final long serialVersionUID = 1L;

    public FileException(String code, Object[] args) {
        super("file", code, args, null);
    }

}
