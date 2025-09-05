require mender-orchestrator-support.inc

################################################################################
#-------------------------------------------------------------------------------
# THINGS TO CONSIDER FOR EACH RELEASE:
# - SRC_URI (particularly "branch")
# - SRCREV
# - DEFAULT_PREFERENCE
#-------------------------------------------------------------------------------

SRC_URI = "git://github.com/mendersoftware/mender-orchestrator-support;protocol=https;branch=feature/MEN-8416-orchestrator"

# We don't actually have a tag 0.1, so point it to the latest revision of feature/MEN-8416-orchestrator
SRCREV = "3487795664d01bb845d407fd23d16ee434b8b741"

# Enable this in Betas, and in branches that cannot carry this major version as
# default.
# Downprioritize this recipe in version selections.
#DEFAULT_PREFERENCE = "-1"

################################################################################

# DO NOT change the checksum here without make sure that ALL licenses (including
# dependencies) are included in the LICENSE variable below.
LIC_FILES_CHKSUM = " \
    file://LICENSE;md5=ed7b7edaf4c941c8d3d64890db92ad92 \
"
LICENSE = "Apache-2.0"
