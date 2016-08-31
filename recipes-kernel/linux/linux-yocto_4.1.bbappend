
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

# For the zynq boards we need additional kernel configuration
SRC_URI += "file://xilinx-zynq-ext.scc"
