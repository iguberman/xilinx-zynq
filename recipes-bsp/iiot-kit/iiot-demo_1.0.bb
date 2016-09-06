DESCRIPTION = "This package provide Avnet IIoT_Kit demo programs."
LICENSE = "GPLv2"
HOMEPAGE = "https://github.com/Avnet/software.git"
LIC_FILES_CHKSUM = "file://README.md;md5=13e29f62d2d5359c264f077638498616"

do_configure[noexec] = "1"

SRC_URI = "git://github.com/Avnet/software.git \
	   file://0001-iiot-kit-fix-the-issue-of-host-cross-building.patch  \
	   file://0002-iiot-kit-fix-the-issue-of-static-variables-definatio.patch \
	   "
SRCREV = "5a96dd29be3ab7ed308ee8d2504c08d5406299cf"

S = "${WORKDIR}/git"

do_compile () {
    oe_runmake -C IIoT_Kit/STM_HTS221/Linux 
    oe_runmake -C IIoT_Kit/Maxim_31855_Pmod/Linux
}

do_install () {
    install -d ${D}/opt/iiot-demo
    install -m 0755 IIoT_Kit/STM_HTS221/Linux/hts221_sensor ${D}/opt/iiot-demo/
    install -m 0755 IIoT_Kit/Maxim_31855_Pmod/Linux/maxim31855_sensor ${D}/opt/iiot-demo/
}

FILES_${PN} += "/opt"
