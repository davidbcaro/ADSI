﻿using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace EON.Models
{
    public class learningResult
    {
        [Key]
        [Display(Name = "idLearningResult")]
        public int id_learningResult { get; set; }

        [Display(Name = "Code")]
        [Required(ErrorMessage = "Field {0} is required")]
        [StringLength(50, ErrorMessage = "Field {0} must contain a maximum of {1} characters and a minimum of (2) characters", MinimumLength = 1)]
        public string Code { get; set; }

        [Display(Name = "Description")]
        [DataType(DataType.MultilineText)]
        [Required(ErrorMessage = "Field {0} is required")]
        [StringLength(100, ErrorMessage = "Field {0} must contain a maximum of {1} characters and a minimum of (2) characters", MinimumLength = 1)]
        public string Description { get; set; }

        public int id_Competition { get; set; }
        public virtual Competition Competition { get; set; }
    }
}