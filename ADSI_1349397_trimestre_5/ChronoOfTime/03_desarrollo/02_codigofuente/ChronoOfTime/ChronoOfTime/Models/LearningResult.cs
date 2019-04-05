using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace ChronoOfTime.Models
{
    public class LearningResult
    {
    [Key]
    [Column(Order = 8)]
    public int IDLearningResult { get; set; }
    [Display(Name = "Code")]
    [Required(ErrorMessage = "El campo {0} es obligatorio")]
    public string code { get; set; }
    [Display(Name = "Description")]
    public string description { get; set; }


        //foreign

    [Display(Name ="Program")]
     public int IDProgram { get; set; }
    
    [Display(Name ="Competence")]
    [Required(ErrorMessage = "El campo {0} es obligatorio")]
    public int IDCompetence { get; set; }
    [ForeignKey("IDCompetence")]
    public Competence Competence { get; set; }

    [NotMapped]
    public string Compro { get { return string.Format("{0} - {1}",Competence.codeCompetence , Competence.Program.codeProgram); } }




    }



}