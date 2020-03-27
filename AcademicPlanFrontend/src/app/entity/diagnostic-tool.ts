export class DiagnosticTool {
  id: number;
  text: string;

  static clone(diagnosticTool: DiagnosticTool): DiagnosticTool{
    let clonedDiagnosticTool = new DiagnosticTool();
    clonedDiagnosticTool.id = diagnosticTool.id;
    clonedDiagnosticTool.text = diagnosticTool.text;
    return clonedDiagnosticTool;
  }
}
