using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace EON.Models
{
    public class Competition
    {
        [Key]
        [Display(Name = "idCompetition")]
        public int id_Competition { get; set; }

        [Display(Name = "codeCompetition")]
        [Required(ErrorMessage = "Field {0} is required")]
        [StringLength(50, ErrorMessage = "Field {0} must contain a maximum of {1} characters and a minimum of (2) characters", MinimumLength = 1)]
        public string Code { get; set; }

        [Display(Name = "Description")]
        [DataType(DataType.MultilineText)]
        [Required(ErrorMessage = "Field {0} is required")]
        [StringLength(100, ErrorMessage = "Field {0} must contain a maximum of {1} characters and a minimum of (2) characters", MinimumLength = 1)]
        public string Description { get; set; }

        [NotMapped]
        public string FullCompetition { get { return string.Format("{0} - {1} ", Code, Program.FullProgram); } }

        public virtual ICollection<learningResult> learningResult { get; set; }

        public int id_Program { get; set; }
        public virtual Program Program { get; set; }

    }
}