require linux-stable.inc

KERNEL_CONFIG_COMMAND = "oe_runmake_call -C ${S} CC="${KERNEL_CC}" O=${B} olddefconfig"

COMPATIBLE_MACHINE = "beaglebone"

KERNEL_DEVICETREE ?= " \
    bbb-mkaul.dtb \
"

LINUX_VERSION = "5.4-rt"
LINUX_VERSION_EXTENSION = "-mkaul"

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-stable-${LINUX_VERSION}-mkaul:${THISDIR}/linux-stable-${LINUX_VERSION}-mkaul/dts:"

S = "${WORKDIR}/git"

PV = "mkaul-5.4"
SRCREV = "7cfa7305d3315c094ea8f2a0628fd5217bc1dcd8"
SRC_URI = " \
    git://github.com/mkauli/linux_beaglebone.git;branch=${LINUX_VERSION}-mkaul \
    file://defconfig \
"
