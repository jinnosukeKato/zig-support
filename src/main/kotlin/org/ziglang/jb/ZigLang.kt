package org.ziglang.jb

import com.intellij.execution.configurations.PathEnvironmentVariableUtil
import com.intellij.lang.Language
import org.ziglang.jb.reference.createLookup

object ZigLang : Language("Zig") {

    val primitiveTypes: List<String>

    init {
        val mutPrimitiveTypes = mutableSetOf<String>()
        for (n in 0..65535) {
            mutPrimitiveTypes.add("i$n")
            mutPrimitiveTypes.add("u$n")
        }
        mutPrimitiveTypes.addAll(
            listOf(
                "isize",
                "usize",
                "c_short",
                "c_ushort",
                "c_int",
                "c_uint",
                "c_long",
                "c_ulong",
                "c_longlong",
                "c_ulonglong",
                "c_longdouble",
//              "c_void",
                "f16",
                "f32",
                "f64",
                "f128",
                "bool",
                "anyopaque",
                "void",
                "noreturn",
                "type",
                "anyerror",
                "comptime_int",
                "comptime_float"
            )
        )
        primitiveTypes = mutPrimitiveTypes.toList()
    }

    const val NOTIFICATION_GROUP_ID = "Zig"

    val zigPath: String? by lazy {
        PathEnvironmentVariableUtil.findInPath("zig")?.absolutePath
    }

    val primitiveTypesLookup = primitiveTypes.map(::createLookup)

    val builtInFunctions = listOf(
        "addrSpaceCast",
        "addWithOverflow",
        "alignCast",
        "alignOf",
        "as",
        "asyncCall",
        "atomicLoad",
        "atomicRmw",
        "atomicStore",
        "bitCast",
        "bitOffsetOf",
        "boolToInt",
        "bitSizeOf",
        "breakpoint",
        "mulAdd",
        "byteSwap",
        "bitReverse",
        "offsetOf",
        "call",
        "cDefine",
        "cImport",
        "cInclude",
        "clz",
        "cmpxchgStrong",
        "cmpxchgWeak",
        "compileError",
        "compileLog",
        "ctz",
        "cUndef",
        "divExact",
        "divFloor",
        "divTrunc",
        "embedFile",
        "enumToInt",
        "errorName",
        "errorReturnTrace",
        "errorToInt",
        "errSetCast",
        "export",
        "extern",
        "fence",
        "field",
        "fieldParentPtr",
        "floatCast",
        "floatToInt",
        "frame",
        "Frame",
        "frameAddress",
        "frameSize",
        "hasDecl",
        "hasField",
        "import",
        "intCast",
        "intToEnum",
        "intToError",
        "intToFloat",
        "intToPtr",
        "max",
        "memcpy",
        "memset",
        "min",
        "wasmMemorySize",
        "wasmMemoryGrow",
        "mod",
        "mulWithOverflow",
        "panic",
        "popCount",
        "prefetch",
        "ptrCast",
        "ptrToInt",
        "rem",
        "returnAddress",
        "select",
        "setAlignStack",
        "setCold",
        "setEvalBranchQuota",
        "setFloatMode",
        "setRuntimeSafety",
        "shlExact",
        "shlWithOverflow",
        "shrExact",
        "shuffle",
        "sizeOf",
        "splat",
        "reduce",
        "src",
        "sqrt",
        "sin",
        "cos",
        "tan",
        "exp",
        "exp2",
        "log",
        "log2",
        "log10",
        "fabs",
        "floor",
        "ceil",
        "trunc",
        "round",
        "subWithOverflow",
        "tagName",
        "This",
        "truncate",
        "Type",
        "typeInfo",
        "typeName",
        "TypeOf",
        "unionInit",
        "Vector",
    )
}