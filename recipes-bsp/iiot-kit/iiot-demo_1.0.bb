DESCRIPTION = "This package provide Avnet IIoT_Kit demo programs."
LICENSE = "GPLv2"
HOMEPAGE = "https://github.com/Avnet/software.git"
LIC_FILES_CHKSUM = "file://IIoT_Kit/IIoT_Quickstart_Demo/COPYING;md5=13e29f62d2d5359c264f077638498616"

do_configure[noexec] = "1"

SRC_URI = "file://IIoT_Kit.tar.gz \
	   file://0001-iiot-kit-fix-the-issue-of-host-cross-building.patch  \
	   file://0002-iiot-kit-fix-the-issue-of-static-variables-definatio.patch \
	   file://0003-iiot-demo-fix-the-cross-building-issue.patch \
	   "

SRC_URI[md5sum] = "0fa870773aa7f15dbd779646ee344a70"
SRC_URI[sha256sum] = "2772a883aef0c5eae69c45560a6c90474160e6f6f75e0364db5763db00d8b68f"

S = "${WORKDIR}"

do_compile () {
    oe_runmake -C IIoT_Kit/STM_HTS221/Linux 
    oe_runmake -C IIoT_Kit/Maxim_31855_Pmod/Linux
    oe_runmake -C IIoT_Kit/IIoT_Bluemix_Demo
    oe_runmake -C IIoT_Kit/IIoT_Quickstart_Demo
}

do_install () {
    install -d ${D}/opt/iiot-demo
    install -m 0755 IIoT_Kit/STM_HTS221/Linux/hts221_sensor ${D}/opt/iiot-demo/
    install -m 0755 IIoT_Kit/Maxim_31855_Pmod/Linux/maxim31855_sensor ${D}/opt/iiot-demo/
    install -m 0755 IIoT_Kit/IIoT_Bluemix_Demo/IIoT_Bluemix_Demo ${D}/opt/iiot-demo/
    install -m 0755 IIoT_Kit/IIoT_Quickstart_Demo/IIoT_QuickStart_Demo ${D}/opt/iiot-demo/
}

FILES_${PN} += "/opt"
