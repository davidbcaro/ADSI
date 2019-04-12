using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Web;

namespace EON.Models
{
    public class Program
    {
        [Key]
        [Display(Name = "idProgram")]
        public int id_Program { get; set; }

        [Display(Name = "Code")]
        [Required(ErrorMessage = "Field {0} is required")]
        [StringLength(50, ErrorMessage = "Field {0} must contain a maximum of {1} characters and a minimum of (2) characters", MinimumLength = 1)]
        public string Code { get; set; }

        [Display(Name = "Name")]
        [Required(ErrorMessage = "Field {0} is required")]
        [StringLength(100, ErrorMessage = "Field {0} must contain a maximum of {1} characters and a minimum of {2} characters", MinimumLength = 1)]
        public string Name { get; set; }

        [Display(Name = "Initials")]
        [Required(ErrorMessage = "Initials" )]
        [StringLength(20, ErrorMessage = "Field {0} must contain a maximum of {1} characters and a minumum of {2} characters", MinimumLength = 1)]
        public string Initials { get; set; }

        [Display(Name = "Status")]
        public bool State { get; set; }

        [NotMapped]
        public string FullProgram { get { return string.Format("{0} - {1} - {2} ", Name, Code, programVersion.Version); } }

        public virtual ICollection<Competition> Competitions { get; set; }

        public int id_Training_Level { get; set; }
        public virtual trainingLevel trainingLevel { get; set; }

        public int id_programVersion { get; set; }
        public virtual programVersion programVersion { get; set; }
    }
}