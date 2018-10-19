package ch.timo_schmid.sbt.purr

import sbt.ModuleID

import scala.language.implicitConversions

object Syntax {

  implicit def toModuleIDOps(moduleID: ModuleID): ModuleIDOps = new ModuleIDOps(moduleID)

  private [purr] class ModuleIDOps(moduleID: ModuleID) {

    def asCompilerPlugin: ModuleID = moduleID.withConfigurations(Some("plugin->default(compile)"))

  }

}
